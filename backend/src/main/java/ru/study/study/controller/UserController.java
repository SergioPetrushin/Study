package ru.study.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.inner.EmailRequest;
import ru.study.study.dto.request.user.*;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.service.UserService;
import ru.study.study.service.utils.MailService;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private final MailService mailService;
    private static final String USER_ADD = "/api/v1/user/add";
    private static final String USER_GET = "/api/v1/user/get";
    private static final String USER_GET_ALL = "/api/v1/user/get-all";
    private static final String USER_EDIT = "/api/v1/user/edit";
    private static final String USER_DELETE = "/api/v1/user/delete";
    private static final String USER_CHANGE_PWD = "/api/v1/user/change-pwd";
    private static final String MAIL_SENDER = "/api/v1/user/mail-sender";
    private static final String USER_CHECK_EMAIL = "/api/v1/user/check-email";
    private static final String USER_CHECK_LOGIN = "/api/v1/user/check-login";
    private static final String USER_LOGIN = "/api/v1/user/login";

    @PostMapping(
            value = USER_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse addUser(@RequestBody UserAddRequest request) {

        return service.addUser(request);
    }

    @PostMapping(
            value = USER_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse getUser(@RequestBody UserRequest request) {

        return service.getUser(request);
    }

    @PostMapping(
            value = USER_GET_ALL,

            produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUser() {
        return service.getAllUser();
    }

    @PostMapping(
            value = USER_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse editUser(@RequestBody UserAddRequest request) {
        return service.editUser(request);
    }

    @PostMapping(
            value = USER_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteUser(@RequestBody UserRequest request) {
        service.deleteUser(request);
        return "User успешно удален";
    }

    @PostMapping(
            value = USER_CHANGE_PWD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String changePWD(@RequestBody UserChangePWDRequest request) {
        return service.changePWD(request);
    }

    @PostMapping(
            value = MAIL_SENDER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String mailSender() {
        mailService.sendMail(new EmailRequest().setTo(Collections.singletonList("vainsergey@yandex.ru"))
                .setSubject("Тестовая тема").setText("Тестовый тест"));
        return "User успешно удален";
    }

    @PostMapping(
            value = USER_CHECK_EMAIL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String userCheckEmail(@RequestBody UserCheckEmailRequest request) {
        return service.userCheckEmail(request);
    }

    @PostMapping(
            value = USER_CHECK_LOGIN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String userCheckLogin(@RequestBody UserCheckLoginRequest request) {
        return service.userCheckLogin(request);
    }

    @PostMapping(
            value = USER_LOGIN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String userLogin(@RequestBody UserLoginRequest request) {
        return service.userLogin(request);
    }

}