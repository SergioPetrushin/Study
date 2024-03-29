package ru.study.study.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.dto.request.educationplan.EducationPlanRequest;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.service.EducationPlanService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
public class EducationPlanController {
    private static final String EDUCATION_PLAN_GET = "/api/v1/education-plan/get";
    private static final String EDUCATION_PLAN_GET_ALL = "/api/v1/education-plan/get-all";
    private static final String EDUCATION_PLAN_ADD = "/api/v1/education-plan/add";
    private static final String EDUCATION_PLAN_DELETE = "/api/v1/education-plan/delete";
    private static final String EDUCATION_PLAN_EDIT = "/api/v1/education-plan/edit";

    private final EducationPlanService service;
    @PostMapping(
            value = EDUCATION_PLAN_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public EducationPlanResponse getEducationPlan(@RequestBody EducationPlanRequest request) {
        return service.getEducationPlan(request);
    }

    @PostMapping(
            value = EDUCATION_PLAN_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<EducationPlanResponse> getAllEducationPlan() {
        return service.getAllEducationPlan();
    }

    @PostMapping(
            value = EDUCATION_PLAN_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public EducationPlanResponse addEducationPlan(@RequestBody EducationPlanAddRequest request) {
        return service.addEducationPlan(request);
    }

    @PostMapping(
            value = EDUCATION_PLAN_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteEducationPlan(@RequestBody EducationPlanRequest request) {
        service.deleteEducationPlan(request);
        return "EducationPlan успешно удален";
    }

    @PostMapping(
            value = EDUCATION_PLAN_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public EducationPlanResponse editEducationPlan(@RequestBody EducationPlanAddRequest request) {
        return service.editEducationPlan(request);
    }
}
