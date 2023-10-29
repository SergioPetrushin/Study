package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.TaskStatusRepository;

@Service
@RequiredArgsConstructor
public class TaskStatusDomainService {
    private final TaskStatusRepository taskStatusRepository;
}
