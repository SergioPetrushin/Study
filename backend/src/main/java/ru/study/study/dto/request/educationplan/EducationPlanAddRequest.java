package ru.study.study.dto.request.educationplan;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class EducationPlanAddRequest {
    private String name;
    private Long userId;
    private String description;
}
