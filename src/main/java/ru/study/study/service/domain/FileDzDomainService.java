package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.FileDzRepository;

@Service
@RequiredArgsConstructor
public class FileDzDomainService {
    private final FileDzRepository fileDzRepository;
}
