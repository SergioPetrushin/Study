package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.task.StudentTaskResponse;
import ru.study.study.entity.task.TaskStatus;
import ru.study.study.mapper.studenttask.StudentTaskResponseMapper;
import ru.study.study.repository.StudentTaskRepository;

import java.security.InvalidParameterException;

@Service
@RequiredArgsConstructor
public class StudentTaskDomainService {
    private final StudentTaskRepository studentTaskRepository;
    private final StudentTaskResponseMapper studentTaskResponseMapper;

    public void changeStatusTask(Long id, Long statusId) {
        var studentTask = studentTaskRepository.findById(id).orElseThrow();
        studentTask.setTaskStatus(new TaskStatus(statusId));
        studentTaskRepository.save(studentTask);

    }

    public StudentTaskResponse getStudentTask(Long id) {
        return studentTaskResponseMapper.from(
                studentTaskRepository.findById(id).orElseThrow(() -> new InvalidParameterException("Задача не найдена!"))
        );
    }
}
