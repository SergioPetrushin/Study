package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.mapper.user.UserMapper;
import ru.study.study.mapper.user.UserResponseMapper;
import ru.study.study.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDomainService {
    private final UserRepository userRepository;

    private final UserMapper userMapper;
    private final UserResponseMapper userResponseMapper;

    @Transactional
    public Long addUser(UserAddRequest request) {
        return userRepository.save(userMapper.from(request)).getId();
    }

    @Transactional
    public UserResponse getUser(Long id) {
       return userResponseMapper.from(userRepository.findById(id).orElseThrow());
    }
}
