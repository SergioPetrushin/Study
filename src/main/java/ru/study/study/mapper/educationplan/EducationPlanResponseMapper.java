package ru.study.study.mapper.educationplan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class EducationPlanResponseMapper implements Mapper<EducationPlanResponse, EducationPlan> {
    @Override
    public EducationPlanResponse from(EducationPlan source) {
        return new EducationPlanResponse()
                .setPlanId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified())
                .setUserId(source.getUser());
    }
}
