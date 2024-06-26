package ru.study.study.service;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.study.study.dto.inner.EmailRequest;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserChangePWDRequest;
import ru.study.study.dto.request.user.UserCheckEmailRequest;
import ru.study.study.dto.request.user.UserCheckLoginRequest;
import ru.study.study.dto.request.user.UserLoginRequest;
import ru.study.study.dto.request.user.UserRequest;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.domain.UserDomainService;
import ru.study.study.service.domain.UserTypeDomainService;
import ru.study.study.service.security.JwtService;
import ru.study.study.service.utils.MailService;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserDomainService userDomainService;
    private final UserTypeDomainService userTypeDomainService;
    private final MailService mailService;
    private final JwtService jwtService;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;


    private static final String REG_PWD = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)(?=.*[!@#$%^&+=]).{6,}";
    private static final String REG_MAIL = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";

    @Operation(summary = "Ввести значение")
    public UserResponse addUser(UserAddRequest request) {

        if (!verification(request.getPassword(), REG_PWD))
            throw new InvalidParameterException("Пароль не подходит. Пароль должен содержать не " +
                    "менее 6 символов, спец символы, большие и маленькие буквы.");

        if (!verification(request.getMail(), REG_MAIL))
            throw new InvalidParameterException("Указан не верный формат e-mail");

        if (userDomainService.checkLogin(request.getLogin()))
            throw new InvalidParameterException("Ошибка: Пользователь с таким логином уже существует.");

        if (userDomainService.checkEmail(request.getMail())) {
            throw new InvalidParameterException("Ошибка: Пользователь с такой почтой уже существует.");
        }

        var emailCode = UUID.randomUUID();
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        var id = userDomainService.addUser(request, emailCode);

        mailService.sendMail(new EmailRequest()
                .setTo(Collections.singletonList(request.getMail()))
                .setSubject("Регистрация на учебном портале")
                .setText(String.format(" Здравствуйте, %s! \n" +
                        "Благодарим за регистрацию на нашем учебном портале, для подтверждения почты просьба перейти по ссылке: \n" +
                        "http://localhost:9000/api/v1/user/confirm-email?code=%s", request.getFullName(), emailCode))
        );

        return userDomainService.getUser(id);
    }

    public UserResponse getUser(Long id) {

        return userDomainService.getUser(id);
    }

    public UserTypeResponse getUserType(UserTypeRequest request) {
        return userTypeDomainService.getUserType(request.getTypeId());
    }

    public List<UserResponse> getAllUser() {
        return userDomainService.getAllUser();
    }

    public void deleteUser(Long id) {
        userDomainService.deleteUser(id);
    }

    public UserResponse editUser(Long id, UserAddRequest request) {
        userDomainService.editUser(id, request);
        return userDomainService.getUser(id);
    }

    public String changePWD(UserChangePWDRequest request) {
        if (verification(request.getPassword(), REG_PWD))
            return userDomainService.changePWD(request);
        else
            return "Пароль не подходит. Пароль должен содержать не " +
                    "менее 6 символов, спец символы, большие и маленькие буквы.";

    }

    private boolean verification(String value, String reg) {
        if (value == null) return false;
        return value.matches(reg);
    }


    public String userCheckEmail(UserCheckEmailRequest request) {
        boolean result = userDomainService.checkEmail(request.getEmail());
        if (result) {
            return "Извините, эта почта уже занята. " +
                    "Вам нужно выбрать другой адрес электронной почты";
        } else {
            return "Такая почта свободна";
        }
    }

    public String userCheckLogin(UserCheckLoginRequest request) {
        boolean result = userDomainService.checkLogin(request.getLogin());
        if (result) {
            return "Ошибка: Пользователь с таким логином уже существует. " +
                    "Пожалуйста, выберите другой логин для регистрации.";
        } else {
            return "Поздравляем! Логин " + request.getLogin() + " доступен для регистрации";
        }
    }

    public String userLogin(UserLoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),request.getPswd()
                )
        );

        var user = userDomainService.getUserByLogin(request.getLogin());

        return jwtService.generateToken(user);
    }

    public String confirmMail(UUID code) {
        if (userDomainService.confirmMail(code)) return "Почта потверждена успешно!";
        else return "Код не найден! Возможно почта была потверждена ранее";
    }
}
