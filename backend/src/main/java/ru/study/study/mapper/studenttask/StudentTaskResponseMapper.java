package ru.study.study.mapper.studenttask;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.task.StudentTaskResponse;
import ru.study.study.entity.task.StudentTask;
import ru.study.study.entity.task.TaskStatusEnum;
import ru.study.study.mapper.Mapper;
import ru.study.study.mapper.task.TaskResponseMapper;

@Service
@RequiredArgsConstructor
public class StudentTaskResponseMapper implements Mapper<StudentTaskResponse, StudentTask> {

    private final TaskResponseMapper taskResponseMapper;


    @Override
    public StudentTaskResponse from(StudentTask source) {
        return new StudentTaskResponse()
                .setId(source.getId())
                .setTask(taskResponseMapper.from(source.getTask()))
                .setStatus(TaskStatusEnum.getById(source.getTaskStatus().getId()))
                .setAssessment(source.getAssesment())
                .setComment(source.getComment())
                .setSolutions(source.getSolution())
                .setExpired(source.getExpiried())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}