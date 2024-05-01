package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.service.EducationPlanService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление обучающими планами")
public class EducationPlanController {


    private static final String EDUCATION_PLAN = "/api/v1/education-plan/{id}";
    private static final String EDUCATION_PLANS = "/api/v1/education-plans";

    private final EducationPlanService service;

    @Operation(summary = "Получение ответа плана обучения")
    @GetMapping(value = EDUCATION_PLAN,
            produces = APPLICATION_JSON_VALUE)
    public EducationPlanResponse getEducationPlan(@PathVariable Long id) {
        return service.getEducationPlan(id);
    }

    @Operation(summary = "Получение ответа всех планов обучения")
    @GetMapping(value = EDUCATION_PLANS,
            produces = APPLICATION_JSON_VALUE)
    public List<EducationPlanResponse> getAllEducationPlan() {
        return service.getAllEducationPlan();
    }

    @Operation(summary = "Добавление плана обучения")
    @PostMapping(
            value = EDUCATION_PLANS,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public EducationPlanResponse addEducationPlan(@RequestBody EducationPlanAddRequest request, Authentication authentication) {
        return service.addEducationPlan(request, authentication);
    }

    @Operation(summary = "Удаление плана обучения")
    @DeleteMapping(
            value = EDUCATION_PLAN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteEducationPlan(@PathVariable Long id) {
        service.deleteEducationPlan(id);
        return "EducationPlan успешно удален";
    }

    @Operation(summary = "Изменение плана обучения")
    @PutMapping(
            value = EDUCATION_PLAN,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public EducationPlanResponse editEducationPlan(@PathVariable Long id, @RequestBody EducationPlanAddRequest request) {
        return service.editEducationPlan(id, request);
    }
}
