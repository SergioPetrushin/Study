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
@Schema(name = "ДТО обучающего плана добавления запроса")
public class EducationPlanAddRequest {
    private String name;
    private Long planId;
    private String description;
}
