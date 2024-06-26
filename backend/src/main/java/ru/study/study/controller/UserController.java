package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserChangePWDRequest;
import ru.study.study.dto.request.user.UserCheckEmailRequest;
import ru.study.study.dto.request.user.UserCheckLoginRequest;
import ru.study.study.dto.request.user.UserLoginRequest;
import ru.study.study.dto.response.ResponseBody;
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


    public static final String USER = "/api/v1/user/{id}";
    public static final String USERS = "/api/v1/users";

    public static final String USER_CHANGE_PWD = "/api/v1/user/change-pwd";
    public static final String USER_CHECK_EMAIL = "/api/v1/user/check-email";
    public static final String USER_CHECK_LOGIN = "/api/v1/user/check-login";
    public static final String USER_LOGIN = "/api/v1/user/login";
    public static final String USER_CONFIRM = "/api/v1/user/confirm-email/{code}";


    @Operation(summary = "Получение пользователя")
    @GetMapping(
            value = USER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public ResponseBody<UserResponse> getUser(@PathVariable Long id) {

        ResponseBody<UserResponse> response;

        try {
            response = ResponseBody.<UserResponse>builder()
                    .success(true)
                    .message("")
                    .data(service.getUser(id))
                    .build();

        } catch (Exception ex) {

            response = ResponseBody.<UserResponse>builder()
                    .success(false)
                    .message(ex.getMessage())
                    .build();
        }

        return response;
    }

    @Operation(summary = "Удаление пользователя")
    @DeleteMapping(
            value = USER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return "User успешно удален";
    }


    @Operation(summary = "Добавление нового пользователя")
    @PostMapping(
            value = USERS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse addUser(@RequestBody UserAddRequest request) {
        return service.addUser(request);
    }


    @Operation(summary = "Изменение пользователя")
    @PutMapping(
            value = USER,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse editUser(@PathVariable Long id, @RequestBody UserAddRequest request) {
        return service.editUser(id, request);
    }

    @Operation(summary = "Получение всех пользователя")
    @GetMapping(
            value = USERS,
            produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUser() {
        return service.getAllUser();
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