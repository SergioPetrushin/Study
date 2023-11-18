package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.dto.response.TaskResponse;
import ru.study.study.service.domain.TaskDomainService;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskDomainService taskDomainService;

    public TaskResponse addTask(TaskAddRequest request) {
        var id = taskDomainService.addTask(request);
        return taskDomainService.getTask(id);
    }

}
