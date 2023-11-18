package ru.study.study.mapper.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.TaskResponse;
import ru.study.study.entity.task.Task;
import ru.study.study.mapper.Mapper;
import ru.study.study.mapper.educationplan.EducationPlanResponseMapper;

@Service
@RequiredArgsConstructor
public class TaskResponseMapper implements Mapper<TaskResponse, Task> {
    private final EducationPlanResponseMapper educationPlanResponseMapper;
    @Override
    public TaskResponse from(Task source) {
        return new TaskResponse()
                .setTaskId(source.getId())
                .setDescription(source.getDescription())
                .setName(source.getName()).setModified(source.getModified())
                .setCreated(source.getCreated())
                .setPlan(educationPlanResponseMapper.from(source.getPlan()))
                .setModified(source.getModified());
    }
}
