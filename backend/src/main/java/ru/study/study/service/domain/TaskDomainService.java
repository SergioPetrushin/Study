package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.dto.response.task.TaskResponse;
import ru.study.study.mapper.task.TaskMapper;
import ru.study.study.mapper.task.TaskMerger;
import ru.study.study.mapper.task.TaskResponseMapper;
import ru.study.study.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskDomainService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskResponseMapper taskResponseMapper;
    private final TaskMerger taskMerger;

    @Transactional
    public Long addTask(TaskAddRequest request) {
        return taskRepository.save(taskMapper.from(request)).getId();

    }

    @Transactional
    public TaskResponse getTask(Long taskId) {
        return taskResponseMapper.from(taskRepository.getReferenceById(taskId));
    }

    @Transactional
    public List<TaskResponse> getAllTask() {
        return taskResponseMapper.from(taskRepository.findAll());
    }

    @Transactional
    public List<TaskResponse> getTasksByPlanId(Long planId) {
        return  taskResponseMapper.from(taskRepository.findAllByPlanId(planId));
    }

    @Transactional
    public void deleteTasksByPlanId(Long planId) {
        taskRepository.deleteAllByPlanId(planId);
    }

    @Transactional
    public Long editTask(TaskAddRequest request) {
        var task = taskRepository.getReferenceById(request.getTaskId());
        return taskRepository.save(taskMerger.merge(task, request)).getId();
    }
}
