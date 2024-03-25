package ru.study.study.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.usertype.UserTypeAddRequest;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.UserTypeService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление типами пользователей")
public class UserTypeController {
    private final UserTypeService userTypeService;

    private static final String USER_TYPE_ADD = "/api/v1/user-type/add";
    private static final String USER_TYPE_GET_ALL = "/api/v1/user-type/get-all";
    private static final String USER_TYPE_GET = "/api/v1/user-type/get";
    private static final String USER_TYPE_DELETE = "/api/v1/user-type/delete";
    private static final String USER_TYPE_EDIT = "/api/v1/user-type/edit";
    @PostMapping(
            value = USER_TYPE_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserTypeResponse addUserType(@RequestBody UserTypeAddRequest request) {
        return userTypeService.addUserType(request);
    }

    @PostMapping(
            value = USER_TYPE_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<UserTypeResponse> getAllUserType() {
        return userTypeService.getAllUserType();
    }

    @PostMapping(
            value = USER_TYPE_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserTypeResponse getUserType(@RequestBody UserTypeRequest request) {
        return userTypeService.getUserType(request);
    }

    @PostMapping(
            value = USER_TYPE_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteUserType(@RequestBody UserTypeRequest request) {
        userTypeService.deleteUserType(request);
        return "UserType успешно удален";
    }

    @PostMapping(
            value = USER_TYPE_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserTypeResponse editUserType(@RequestBody UserTypeAddRequest request) {
        return userTypeService.editUserType(request);
    }

}
