package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.study.study.dto.response.ResponseBody;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.service.StudentTaskService;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление задачами студента")
public class StudentTaskController {
    private final StudentTaskService service;
    private static final String STUDENT_TASK = "/api/v1/student-task/{id}";
    private static final String STUDENT_TASKS = "/api/v1/student-task";
    private static final String STUDENT_TASK_CHANGE_STATUS = STUDENT_TASK+"/change-status/{status-id}";
    @Operation(summary = "Изменение плана обучения")
    @GetMapping(
            value = STUDENT_TASK_CHANGE_STATUS,
            produces = APPLICATION_JSON_VALUE)
    public ResponseBody<Object> changeStatusTask(@PathVariable("id") Long id, @PathVariable("status-id") Long statusId) {
        ResponseBody<Object> response;
        try {
            response = ResponseBody.builder()
                    .success(true)
                    .message(service.changeStatusTask(id, statusId))
                    .build();
        } catch (Exception ex){
            response = ResponseBody.builder()
                    .success(false)
                    .message(ex.getMessage())
                    .build();
        }
        return response;
    }
}
