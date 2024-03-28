package ru.study.study.dto.request.educationplan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class EducationPlanRequest {
    @Schema(description = "ID плана")
    private Long planId;
}
