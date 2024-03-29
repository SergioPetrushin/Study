package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.mapper.userstatus.UserStatusResponseMapper;
import ru.study.study.mapper.userstatus.UserStatusMapper;
import ru.study.study.mapper.userstatus.UserStatusMerger;
import ru.study.study.repository.UserStatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusDomainService {

    private final UserStatusRepository repository;

    private final UserStatusResponseMapper userStatusResponseMapper;
    private final UserStatusMapper userStatusMapper;
    private final UserStatusMerger userStatusMerger;


    @Transactional
    public Long addUserStatus(UserStatusAddRequest request) {
        return repository.save(userStatusMapper.from(request)).getId();

    }

    @Transactional
    public UserStatusResponse getUserStatus(Long statusId) {
        return userStatusResponseMapper.from(repository.getReferenceById(statusId));
    }

    @Transactional
    public Long editUserStatus(UserStatusAddRequest request){
        var status = repository.getReferenceById(request.getStatusId());
        return  repository.save(userStatusMerger.merge(status, request)).getId();
    }

    @Transactional
    public UserStatusResponse getUserStatusByName(String name) {
        return userStatusResponseMapper.from(repository.getUserStatusByName(name));
    }

    @Transactional
    public void deleteUserStatus(Long statusId) {

        repository.deleteById(statusId);
    }

    @Transactional
    public List<UserStatusResponse> getAllUserStatus() {

        return userStatusResponseMapper.from(repository.findAll());
    }

}
