package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.dto.request.task.TaskRequest;
import ru.study.study.dto.response.task.TaskResponse;
import ru.study.study.service.TaskService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление задачами")
public class TaskController {
    private final TaskService service;
    private static final String TASK_ADD = "/api/v1/task/add";
    private static final String TASK_GET = "/api/v1/task/get";
    private static final String TASK_EDIT = "/api/v1/task/egit";
    private static final String TASK_GET_ALL = "/api/v1/task/get-all";
    private static final String DELETE_TASK = "/api/v1/task/delete-task";
    @Operation(summary = "Добавление задачи")
    @PostMapping(
            value = TASK_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public TaskResponse addTask(@RequestBody TaskAddRequest request) {
        return service.addTask(request);
    }
    @Operation(summary = "Получение задачи")
    @PostMapping(value = TASK_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public TaskResponse getTask(@RequestBody TaskRequest request) {
        return service.getTask(request);
    }

    @Operation(summary = "Изменение задачи")
    @PostMapping(
            value = TASK_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public TaskResponse editTask(@RequestBody TaskAddRequest request) {
        return service.editTask(request);
    }
    @Operation(summary = "Получение всех задач")
    @PostMapping(
            value = TASK_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<TaskResponse> getAllTask() {
        return service.getAllTask();
    }
    @Operation(summary = "Удаление задачи")
    @PostMapping(
            value = DELETE_TASK,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteTask(@RequestBody TaskRequest request) {
        service.deleteTask(request);
        return "Task успешно удален";
    }
}
