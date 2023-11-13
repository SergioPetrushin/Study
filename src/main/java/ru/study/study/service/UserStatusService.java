package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.UserAddRequest;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.response.UserStatusResponse;
import ru.study.study.service.domain.UserStatusDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusService {
    private final UserStatusDomainService userStatusDomainService;

    public UserStatusResponse getUserStatus(UserAddRequest request) {
        return userStatusDomainService.getUserStatus(request.getStatusId());
        //Скоррее всего не верно, так как нам же нужен ID User'a?
    }

    public List<UserStatusResponse> getAllUserStatus(UserStatusAddRequest request) {
        return userStatusDomainService.getAllUserStatus();
        //Нет примеров на метод getAll, поэтому не ясно что передавать и что возвращать
    }

    public void deletUserStatus(UserStatusAddRequest request) {
        // всегда вопрос, что нужно возвращать в таких методах
        userStatusDomainService.deleteUserStatus(request.getStatusId());

    }
}
