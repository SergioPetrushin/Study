package ru.study.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.UserAddRequest;
import ru.study.study.dto.request.UserRequest;
import ru.study.study.dto.response.UserResponse;
import ru.study.study.service.UserService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    private static final String USER_ADD = "/api/v1/user/add";
    private static final String USER_GET = "/api/v1/user/get";






    @PostMapping(
            value = USER_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse addStatus(@RequestBody UserAddRequest request) {
        return service.addUser(request);
    }

    @PostMapping(
            value = USER_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public UserResponse addStatus(@RequestBody UserRequest request) {
        return service.getUser(request);
    }
}
