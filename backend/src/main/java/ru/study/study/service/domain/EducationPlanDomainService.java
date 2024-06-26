package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.entity.user.User;
import ru.study.study.mapper.educationplan.EducationPlanMapper;
import ru.study.study.mapper.educationplan.EducationPlanMerger;
import ru.study.study.mapper.educationplan.EducationPlanResponseMapper;
import ru.study.study.repository.EducationPlanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationPlanDomainService {
    private final EducationPlanRepository repository;
    private final EducationPlanMapper educationPlanMapper;
    private final EducationPlanMerger educationPlanMerger;
    private final EducationPlanResponseMapper educationPlanResponseMapper;

    @Transactional
    public void editEducationPlan(Long planId, EducationPlanAddRequest request) {
        var plan = repository.getReferenceById(planId);
        educationPlanMerger.merge(plan, request);
        repository.save(plan);
    }

    @Transactional
    public Long addEducationPlan(EducationPlanAddRequest request, Long currentUserId) {
        var plan = educationPlanMapper.from(request);
        plan.setUser(new User(currentUserId));
        return repository.save(plan).getId();

    }

    @Transactional
    public EducationPlanResponse getEducationPlan(Long id) {
        return educationPlanResponseMapper.from(repository.getReferenceById(id));
    }

    @Transactional
    public List<EducationPlanResponse> getAllEducationPlan() {

        return educationPlanResponseMapper.from(repository.findAll());
    }

    @Transactional
    public void deleteEducationPlan(Long id) {
        repository.deleteById(id);
    }
}
