package ru.study.study.mapper.studenttask;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.studenttask.StudentTaskAddRequest;
import ru.study.study.entity.task.StudentTask;
import ru.study.study.entity.task.Task;
import ru.study.study.entity.task.TaskStatus;
import ru.study.study.entity.task.TaskStatusEnum;
import ru.study.study.entity.user.User;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class StudentTaskMapper implements Mapper<StudentTask, StudentTaskAddRequest> {
    @Override
    public StudentTask from(StudentTaskAddRequest source) {
        return new StudentTask()
                .setTask(new Task(source.getTaskId()))
                .setUser(new User(source.getStudentId()))
                .setExpiried(source.getExpired())
                .setTaskStatus(new TaskStatus(TaskStatusEnum.ISSUED.getId()));
    }
}
