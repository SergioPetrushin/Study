package ru.study.study.mapper.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.entity.task.Task;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class TaskMapper implements Mapper<Task, TaskAddRequest> {

    @Override
    public Task from(TaskAddRequest source) {
        return new Task()
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setPlan(new EducationPlan(source.getPlanId()))
                .setOrdinal(source.getOrdinal());

    }
}
