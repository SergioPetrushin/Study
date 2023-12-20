package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.dto.request.educationplan.EducationPlanRequest;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.service.domain.EducationPlanDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationPlanService {
    private final EducationPlanDomainService service;

    public EducationPlanResponse addEducationPlan(EducationPlanAddRequest request) {
        var id = service.addEducationPlan(request);
        return service.getEducationPlan(id);
    }

    public EducationPlanResponse getEducationPlan(EducationPlanRequest request) {
        return service.getEducationPlan(request.getPlanId());
    }

    public List<EducationPlanResponse> getAllEducationPlan(){
        return service.getAllEducationPlan();
    }

    public void deleteEducationPlan(EducationPlanRequest request){

        service.deleteEducationPlan(request.getPlanId());
    }

    public EducationPlanResponse editEducationPlan(EducationPlanAddRequest request) {
        service.editEducationPlan(request);
        return service.getEducationPlan(request.getUserId());
    }
}
