package ru.study.study.mapper.educationplan;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.mapper.Mapper;
import ru.study.study.mapper.user.UserResponseMapper;

@Service
@RequiredArgsConstructor
public class EducationPlanResponseMapper implements Mapper<EducationPlanResponse, EducationPlan> {
    private final UserResponseMapper userMapper;
    @Override
    public EducationPlanResponse from(EducationPlan source) {
        return new EducationPlanResponse()
                .setPlanId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified())
                .setUser(userMapper.from(source.getUser()));
    }
}
