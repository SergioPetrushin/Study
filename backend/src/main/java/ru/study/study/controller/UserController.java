package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserChangePWDRequest;
import ru.study.study.dto.request.user.UserCheckEmailRequest;
import ru.study.study.dto.request.user.UserCheckLoginRequest;
import ru.study.study.dto.request.user.UserLoginRequest;
import ru.study.study.dto.request.user.UserRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.service.UserService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление пользователями")
public class UserController {

    private final UserService service;
    private static final String USER_ADD = "/api/v1/user/add";
    private static final String USER_GET = "/api/v1/user/get";
    private static final String USER_GET_ALL = "/api/v1/user/get-all";
    private static final String USER_EDIT = "/api/v1/user/edit";
    private static final String USER_DELETE = "/api/v1/user/delete";
    private static final String USER_CHANGE_PWD = "/api/v1/user/change-pwd";
    private static final String USER_CHECK_EMAIL = "/api/v1/user/check-email";
    private static final String USER_CHECK_LOGIN = "/api/v1/user/check-login";
    private static final String USER_LOGIN = "/api/v1/user/login";
    private static final String USER_CONFIRM = "/api/v1/user/confirm-email/{code}";

    @Operation(summary = "Добавление нового пользователя")
    @PostMapping(
            value = USER_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse addUser(@RequestBody UserAddRequest request) {

        return service.addUser(request);
    }
    @Operation(summary = "Получение пользователя")
    @PostMapping(
            value = USER_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse getUser(@RequestBody UserRequest request) {

        return service.getUser(request);
    }
    @Operation(summary = "Получение всех пользователя")
    @PostMapping(
            value = USER_GET_ALL,

            produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUser() {
        return service.getAllUser();
    }
    @Operation(summary = "Изменение пользователя")
    @PostMapping(
            value = USER_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse editUser(@RequestBody UserAddRequest request) {
        return service.editUser(request);
    }
    @Operation(summary = "Удаление пользователя")
    @PostMapping(
            value = USER_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteUser(@RequestBody UserRequest request) {
        service.deleteUser(request);
        return "User успешно удален";
    }
    @Operation(summary = "Изменение пароля пользователя")
    @PostMapping(
            value = USER_CHANGE_PWD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String changePWD(@RequestBody UserChangePWDRequest request) {
        return service.changePWD(request);
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

    @GetMapping(value = USER_CONFIRM)
    public String confirmMail(@PathVariable UUID code) {
        return service.confirmMail(code);
    }

}