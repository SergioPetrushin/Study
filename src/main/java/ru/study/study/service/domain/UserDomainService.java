package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserDomainService {
    private final UserRepository userRepository;
}
