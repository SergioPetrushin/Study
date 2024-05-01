package ru.study.study.mapper.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.entity.task.Task;
import ru.study.study.mapper.Merger;
@Service
@RequiredArgsConstructor
public class TaskMerger implements Merger<Task, TaskAddRequest> {
    @Override
    public Task merge(Task target, TaskAddRequest source) {
        return target.setName(source.getName())
                .setPlan(new EducationPlan(source.getPlanId()))
                .setDescription(source.getDescription())
                .setOrdinal(source.getOrdinal());
    }
}
