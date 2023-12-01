package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.dto.response.task.TaskRequest;
import ru.study.study.dto.response.task.TaskResponse;
import ru.study.study.service.domain.TaskDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskDomainService taskDomainService;

    public TaskResponse addTask(TaskAddRequest request) {
        var id = taskDomainService.addTask(request);
        return taskDomainService.getTask(id);
    }

    public TaskResponse getTask(TaskRequest request){
        return taskDomainService.getTask(request.getTaskId());
    }

    public void deleteTask(TaskRequest request){
        taskDomainService.deleteTask(request.getTaskId());
    }

    public TaskResponse editTask(TaskAddRequest request) {
        var id = taskDomainService.editTask(request);
        return taskDomainService.getTask(id);
    }

    public List<TaskResponse> getAllTask(){
        return taskDomainService.getAllTask();
    }
}
