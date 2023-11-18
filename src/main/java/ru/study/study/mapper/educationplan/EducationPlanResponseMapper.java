package ru.study.study.mapper.educationplan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.mapper.Mapper;
import ru.study.study.mapper.user.UserResponseMapper;
@Service
@RequiredArgsConstructor
public class EducationPlanResponseMapper implements Mapper<EducationPlanResponse, EducationPlan> {
    private final UserResponseMapper userResponseMapper;
    @Override
    public EducationPlanResponse from(EducationPlan source) {
        return new EducationPlanResponse()
                .setPlanId(source.getId())
                .setDescription(source.getDescription())
                .setName(source.getName())
                .setModified(source.getModified())
                .setCreated(source.getCreated())
                .setUser((userResponseMapper.from(source.getUser())));
    }
}
