package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.usertype.UserTypeAddRequest;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.usertype.UserTypeMapper;
import ru.study.study.mapper.usertype.UserTypeMerger;
import ru.study.study.mapper.usertype.UserTypeResponseMapper;
import ru.study.study.repository.UserTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeDomainService {
    private final UserTypeRepository repository;
    private final UserTypeResponseMapper userTypeResponseMapper;
    private final UserTypeMapper userTypeMapper;
    private final UserTypeMerger userTypeMerger;
    @Transactional
    public void editUserType(UserTypeAddRequest request) {
        var type = repository.getReferenceById(request.getTypeId());
        userTypeMerger.merge(type, request);
        repository.save(type);
    }

    @Transactional
    public Long addUserType(UserTypeAddRequest request) {
        UserType userType = userTypeMapper.from(request);
        return repository.save(userType).getId();

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
        repository.deleteById(id);

    }

}
