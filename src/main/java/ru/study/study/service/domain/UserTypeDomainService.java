package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.mapper.usertype.UserTypeRequestMapper;
import ru.study.study.mapper.usertype.UserTypeResponseMapper;
import ru.study.study.repository.UserTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeDomainService {
    private final UserTypeRepository repository;
    private final UserTypeResponseMapper userTypeResponseMapper;
    private final UserTypeRequestMapper userTypeRequestMapper;

    @Transactional
    public Long addUserType(UserTypeRequest request) {
        return repository.save(userTypeRequestMapper.from(request)).getId();
    }

    @Transactional
    public UserTypeResponse getUserType(Long id) {
        return userTypeResponseMapper.from(repository.getReferenceById(id));
    }

    @Transactional
    public List<UserTypeResponse> getAllUserType() {
        return userTypeResponseMapper.from(repository.findAll());
    }

    @Transactional
    public void deleteUserType(Long id) {
        
    }

}
