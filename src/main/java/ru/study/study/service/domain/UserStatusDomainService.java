package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.response.UserStatusResponse;
import ru.study.study.mapper.userstatus.UserResponseMapper;
import ru.study.study.mapper.userstatus.UserStatusMapper;
import ru.study.study.repository.UserStatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusDomainService {

    private final UserStatusRepository repository;

    private final UserResponseMapper userResponseMapper;
    private final UserStatusMapper userStatusMapper;


    @Transactional
    public Long addUserStatus(UserStatusAddRequest request) {
        return repository.save(userStatusMapper.from(request)).getId();
    }

    @Transactional
    public UserStatusResponse getUserStatus(Long statusId) {
        return userResponseMapper.from(repository.getReferenceById(statusId));
    }

    @Transactional
    public UserStatusResponse getUserStatusByName(String name) {
        return userResponseMapper.from(repository.getUserStatusByName(name));
    }

    @Transactional
    public void deleteUserStatus(Long statusId) {
        repository.deleteById(statusId);
    }

    @Transactional
    public List<UserStatusResponse> getAllUserStatus() {
        return userResponseMapper.from(repository.findAll());
    }

}
