package ru.study.study.mapper.educationplan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class EducationPlanMapper implements Mapper<EducationPlan, EducationPlanAddRequest> {
    @Override
    public EducationPlan from(EducationPlanAddRequest source) {
        return new EducationPlan()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
