package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.UserAddRequest;
import ru.study.study.dto.request.UserRequest;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.response.UserResponse;
import ru.study.study.dto.response.UserStatusResponse;
import ru.study.study.service.domain.UserDomainService;
import ru.study.study.service.domain.UserStatusDomainService;
import ru.study.study.service.domain.UserTypeDomainService;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserStatusDomainService userStatusDomainService;
    private final UserDomainService userDomainService;
    private final UserTypeDomainService userTypeDomainService;


    public UserStatusResponse addStatus(UserStatusAddRequest request){
        var id = userStatusDomainService.addUserStatus(request);
        return userStatusDomainService.getUserStatus(id);
    }

    public UserStatusResponse editStatus(UserStatusAddRequest request){
        var id = userStatusDomainService.editUserStatus(request);
        return userStatusDomainService.getUserStatus(id);
    }


    public UserResponse addUser(UserAddRequest request) {
        var id = userDomainService.addUser(request);
        return  userDomainService.getUser(id);
    }

    public UserResponse getUser(UserRequest request) {

        return  userDomainService.getUser(request.getUserId());
    }
}
