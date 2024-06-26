package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.service.UserStatusService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление статусами пользователей")
public class UserStatusController {

    private static final String USER_STATUS_ADD = "/api/v1/user-status/add";
    private static final String USER_STATUS_EDIT = "/api/v1/user-status/edit";
    private static final String USER_STATUS_GET_ALL = "/api/v1/user-status/get-all";


    private final UserStatusService service;
    @Operation(summary = "Добавление статуса пользователя")
    @PostMapping(
            value = USER_STATUS_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserStatusResponse addStatus(@RequestBody UserStatusAddRequest request) {
        return service.addStatus(request);
    }

    @Operation(summary = "Изменение статуса пользователя")
    @PostMapping(
            value = USER_STATUS_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserStatusResponse editStatus(@RequestBody UserStatusAddRequest request) {
        return service.editStatus(request);
    }

    @Operation(summary = "Получение статуса пользователя")
    @PostMapping(
            value = USER_STATUS_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<UserStatusResponse> getAllStatus() {
        return service.getAllUserStatus();
    }


}
