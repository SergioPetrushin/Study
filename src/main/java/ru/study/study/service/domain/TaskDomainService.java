package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskDomainService {
    private final TaskRepository taskRepository;
}
