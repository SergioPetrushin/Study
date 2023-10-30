package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.StudentTaskRepository;

@Service
@RequiredArgsConstructor
public class StudentTaskDomainService {
    private final StudentTaskRepository studentTaskRepository;
}
