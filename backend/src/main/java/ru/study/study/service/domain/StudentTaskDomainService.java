package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.entity.task.TaskStatus;
import ru.study.study.repository.StudentTaskRepository;

@Service
@RequiredArgsConstructor
public class StudentTaskDomainService {
    private final StudentTaskRepository studentTaskRepository;

    public void changeStatusTask(Long id, Long statusId) {
        var studentTask = studentTaskRepository.findById(id).orElseThrow();
        studentTask.setTaskStatus(new TaskStatus(statusId));
        studentTaskRepository.save(studentTask);

    }
}
