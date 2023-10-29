package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.entity.user.UserType;
import ru.study.study.repository.UserTypeRepository;

@Service
@RequiredArgsConstructor
public class UserTypeDomainService {
    private final UserTypeRepository userTypeRepository;

    @Transactional
 public UserType getUserType(Long id){
     return userTypeRepository.getReferenceById(id);
 }

}
