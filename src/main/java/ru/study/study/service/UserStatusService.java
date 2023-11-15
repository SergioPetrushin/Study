package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.UserAddRequest;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.request.userstatus.UserStatusRequest;
import ru.study.study.dto.response.UserStatusResponse;
import ru.study.study.service.domain.UserStatusDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusService {
    private final UserStatusDomainService userStatusDomainService;

    public UserStatusResponse getUserStatus(UserStatusRequest request) {
        return userStatusDomainService.getUserStatus(request.getStatusId());
    } //

    public List<UserStatusResponse> getAllUserStatus() {
        return userStatusDomainService.getAllUserStatus();
    }

    public void deletUserStatus(UserStatusAddRequest request) {
        userStatusDomainService.deleteUserStatus(request.getStatusId());
    }
}
