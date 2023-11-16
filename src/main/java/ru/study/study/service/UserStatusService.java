package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.request.userstatus.UserStatusRequest;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.service.domain.UserStatusDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusService {

    private final UserStatusDomainService userStatusDomainService;

    public UserStatusResponse getUserStatus(UserStatusRequest request) {
        return userStatusDomainService.getUserStatus(request.getStatusId());
    } 

    public List<UserStatusResponse> getAllUserStatus() {
        return userStatusDomainService.getAllUserStatus();
    }

    public void deleteUserStatus(UserStatusAddRequest request) {
        userStatusDomainService.deleteUserStatus(request.getStatusId());
    }

    public UserStatusResponse addStatus(UserStatusAddRequest request){
        var id = userStatusDomainService.addUserStatus(request);
        return userStatusDomainService.getUserStatus(id);
    }

    public UserStatusResponse editStatus(UserStatusAddRequest request){
        var id = userStatusDomainService.editUserStatus(request);
        return userStatusDomainService.getUserStatus(id);
    }


}
