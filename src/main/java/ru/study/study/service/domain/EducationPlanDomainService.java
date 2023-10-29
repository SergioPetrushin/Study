package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.EducationPlanRepository;

@Service
@RequiredArgsConstructor
public class EducationPlanDomainService {
    private final EducationPlanRepository educationPlanRepository;
}
