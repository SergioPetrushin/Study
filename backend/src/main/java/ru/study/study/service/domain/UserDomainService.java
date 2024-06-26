package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.user.*;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.entity.user.User;
import ru.study.study.mapper.user.UserMapper;
import ru.study.study.mapper.user.UserMerger;
import ru.study.study.mapper.user.UserResponseMapper;
import ru.study.study.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserDomainService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;
    private final UserResponseMapper userResponseMapper;
    private final UserMerger userMerger;

    @Transactional
    public Long addUser(UserAddRequest request, UUID emailCode) {
        var user = userMapper.from(request);
        user.setEmailCode(emailCode);
        return userRepository.save(user).getId();
    }

    @Transactional
    public UserResponse getUser(Long id) {
        return userResponseMapper.from(userRepository.findById(id).orElseThrow());
    }

    @Transactional
    public List<UserResponse> getAllUser() {
        return userResponseMapper.from(userRepository.findAll());
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    public void editUser(Long id, UserAddRequest request) {
        var user = userRepository.getReferenceById(id);
        userMerger.merge(user, request);
        userRepository.save(user);
    }

    public String changePWD(UserChangePWDRequest request) {
        var user = userRepository.findUserByLogin(request.getLogin())
                .orElseThrow(() -> new RuntimeException("Пользователь с заданным логином не найден"));
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return "Пароль успешно изменен";
    }

    public boolean checkEmail(String email) {
        return userRepository.existsUsersByEmail(email);
    }

    public boolean checkLogin(String login) {
        return userRepository.existsUsersByLogin(login);
    }

    public String userLogin(UserLoginRequest request) {
    /*    boolean login = userRepository.existsUsersByLogin(request.getLogin());
        String pswd = userRepository.findPasswordByLogin(request.getLogin());
        String message = null;
        if(login&&(pswd.equals(request.getPswd()))){
            System.out.println();
            message = "Пароль соответствует логину";

        } else {
            message = "Такой логин не существует или пароль не соответствует логину";
        }
        return message;*/

        //TODO
        return null;
    }

    public boolean confirmMail(UUID code) {

        var result = userRepository.findUserByEmailCode(code);

        if (result.isPresent()){
          var user = result.get().setEmailCode(null);
          userRepository.save(user);
          return true;
        }

        else return false;
    }

    @Transactional
    public User getUserByLogin(String login){
        return userRepository.findUserByLogin(login).orElseThrow();
    }

    public UserDetailsService userDetailsService() {
        return this::getUserByLogin;
    }

}
