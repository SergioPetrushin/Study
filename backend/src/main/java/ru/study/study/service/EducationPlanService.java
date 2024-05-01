package ru.study.study.service;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.service.domain.EducationPlanDomainService;
import ru.study.study.service.domain.TaskDomainService;
import ru.study.study.service.domain.UserDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationPlanService {
    private final EducationPlanDomainService domainService;
    private final TaskDomainService taskDomainService;
    private final UserDomainService userDomainService;

    public EducationPlanResponse addEducationPlan(EducationPlanAddRequest request, Authentication authentication) {

        var currentUser = userDomainService.getUserByLogin(authentication.getName());
        var id = domainService.addEducationPlan(request, currentUser.getId());

        request.getTasks().forEach( task -> {
            task.setPlanId(id);
            taskDomainService.addTask(task);
        });

        var result = domainService.getEducationPlan(id);
        result.setTasks(taskDomainService.getTasksByPlanId(id));
        return result;
    }

    public EducationPlanResponse getEducationPlan(Long planId) {
        var result = domainService.getEducationPlan(planId);
        result.setTasks(taskDomainService.getTasksByPlanId(planId));
        return result;
    }

    public List<EducationPlanResponse> getAllEducationPlan(){
        return domainService.getAllEducationPlan();
    }

    public void deleteEducationPlan(Long planId){
        taskDomainService.deleteTasksByPlanId(planId);
        domainService.deleteEducationPlan(planId);
    }

    public EducationPlanResponse editEducationPlan(Long planId, EducationPlanAddRequest request) {

        taskDomainService.deleteTasksByPlanId(planId);
        domainService.editEducationPlan(planId,request);
        request.getTasks().forEach( task -> {
            task.setPlanId(planId);
            taskDomainService.addTask(task);
        });

        return domainService.getEducationPlan(planId);
    }
}
