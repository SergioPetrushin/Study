package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.studenttask.StudentTaskAddRequest;
import ru.study.study.dto.response.studenttask.StudentTaskResponse;
import ru.study.study.service.StudentTaskService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Сервис назначения задачи ученику")
public class StudentTaskController {
    private static final String STUDENT_TASKS = "/api/v1/student-tasks";
    //private static final String
private final StudentTaskService taskService;

    @Operation(summary = "Добавление задачи ученику")
    @PostMapping(
            value = STUDENT_TASKS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public StudentTaskResponse addStudentTask(@RequestBody StudentTaskAddRequest request) {
        return taskService.addStudentTask(request);
    }
}