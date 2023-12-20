package ru.study.study.mapper.educationplan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.mapper.Merger;

@Service
@RequiredArgsConstructor
public class EducationPlanMerger implements Merger<EducationPlan, EducationPlanAddRequest> {
    @Override
    public EducationPlan merge(EducationPlan target, EducationPlanAddRequest source) {
        return target
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
