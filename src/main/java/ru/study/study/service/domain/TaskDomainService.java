package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.dto.response.TaskResponse;
import ru.study.study.entity.task.Task;
import ru.study.study.mapper.task.TaskMapper;
import ru.study.study.mapper.task.TaskResponseMapper;
import ru.study.study.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskDomainService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskResponseMapper taskResponseMapper;

@Transactional
    public Long addTask(TaskAddRequest request){
    Task task = taskMapper.from(request);
    return taskRepository.save(task).getId();
}

@Transactional
    public TaskResponse getTask(Long taskId){
    return taskResponseMapper.from(taskRepository.getReferenceById(taskId));
}


}
