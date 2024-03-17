package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.user.*;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.domain.UserDomainService;
import ru.study.study.service.domain.UserTypeDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserDomainService userDomainService;
    private final UserTypeDomainService userTypeDomainService;


    public UserResponse addUser(UserAddRequest request) {
        if (verification(null, request.getMail())) {
            var id = userDomainService.addUser(request);
            return userDomainService.getUser(id);
        } else {
            System.out.println("Такой e-mail уже существует!");
            return null;
        }

    }

    public UserResponse getUser(UserRequest request) {

        return userDomainService.getUser(request.getUserId());
    }

    public UserTypeResponse getUserType(UserTypeRequest request) {
        return userTypeDomainService.getUserType(request.getTypeId());
    }

    public List<UserResponse> getAllUser() {
        return userDomainService.getAllUser();
    }

    public void deleteUser(UserRequest request) {
        userDomainService.deleteUser(request.getUserId());
    }

    public UserResponse editUser(UserAddRequest request) {
        userDomainService.editUser(request);
        return userDomainService.getUser(request.getUserId());
    }

    public String changePWD(UserChangePWDRequest request) {
        if (verification(request.getPassword(), null)) {
            return userDomainService.changePWD(request);
        } else {
            return "Пароль не подходит. Пароль должен содержать не " +
                    "менее 6 символов, спец символы, большие и маленькие буквы.";
        }
    }

    private boolean verification(String pwd, String mail) {
        //Проверка почты и пароля на валидность
        String pwdReg = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=\\S+$)(?=.*[!@#$%^&+=]).{6,}";
        String mailRed = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";
        boolean result = false;
        if (mail == null) {
            if (pwd.matches(pwdReg)) {
                result = true;
            } else {
                result = false;
            }
        }

        if (pwd == null) {
            if (mail.matches(mailRed)) {
                result = true;
            }
        } else {
            result = false;
        }
        return result;
    }


    public String userCheckEmail(UserCheckEmailRequest request) {
        boolean result = userDomainService.checkEmail(request);
        if (result == true) {
            return "Извините, эта почта уже занята. " +
                    "Вам нужно выбрать другой адрес электронной почты";
        } else {
            return "Такая почта свободна";
        }
    }

    public String userCheckLogin(UserCheckLoginRequest request) {
        boolean result = userDomainService.checkLogin(request);
        if (result == true) {
            return "Ошибка: Пользователь с таким логином уже существует. " +
                    "Пожалуйста, выберите другой логин для регистрации.";
        } else {
            return "Поздравляем! Логин " + request.getLogin() + " доступен для регистрации";
        }
    }

    public String userLogin(UserLoginRequest request) {
        String message = userDomainService.userLogin(request);
        return message;
    }

}
