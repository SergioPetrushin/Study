package ru.study.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserRequest;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    private static final String USER_STATUS_ADD = "/api/v1/user-status/add";
    private static final String USER_STATUS_EDIT = "/api/v1/user-status/edit";
    private static final String USER_ADD = "/api/v1/user/add";
    private static final String USER_GET = "/api/v1/user/get";
    private static final String USER_TYPE_GET = "/api/v1/user-type/get";



    @PostMapping(
            value = USER_STATUS_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserStatusResponse addStatus(@RequestBody UserStatusAddRequest request) {
        return service.addStatus(request);
    }


    @PostMapping(
            value = USER_STATUS_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserStatusResponse editStatus(@RequestBody UserStatusAddRequest request) {
        return service.editStatus(request);
    }


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
            value = USER_TYPE_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserTypeResponse getUserType(@RequestBody UserTypeRequest request){
        return service.getUserType(request);
    }

}
