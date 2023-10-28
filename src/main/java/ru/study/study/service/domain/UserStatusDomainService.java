package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.entity.user.UserStatus;
import ru.study.study.repository.UserStatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserStatusDomainService {

    private final UserStatusRepository repository;


    @Transactional
    public void addUserStatus() {
        repository.save(new UserStatus());
    }

    @Transactional
    public void getUserStatus(Long statusId) {
        var status1 = repository.getReferenceById(statusId);
    }

    @Transactional
    public void getUserStatusByName(String name) {
        var status = repository.getUserStatusByName(name);
    }

    @Transactional
    public void deleteUserStatus(Long statusId) {
        repository.deleteById(statusId);
    }

    @Transactional
    public List<UserStatus> getAllUserStatus() {
        return repository.findAll();
    }

}
