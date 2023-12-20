package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.enothers.EducationPlan;
@Repository
public interface EducationPlanRepository extends JpaRepository<EducationPlan, Long> {
}
