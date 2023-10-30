package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
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




}
