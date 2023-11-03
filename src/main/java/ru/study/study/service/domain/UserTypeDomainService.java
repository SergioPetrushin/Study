package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.mapper.usertype.UserTypeResponseMapper;
import ru.study.study.repository.UserTypeRepository;

@Service
@RequiredArgsConstructor
public class UserTypeDomainService {
    private final UserTypeRepository userTypeRepository;
    private final UserTypeResponseMapper userTypeResponseMapper;

    @Transactional
    public UserTypeResponse getUserType(Long id) {

        return userTypeResponseMapper.from(userTypeRepository.getReferenceById(id));
    }

}
