package ru.study.study.dto.response.task;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class TaskResponse {
    private Long taskId;
    private EducationPlanResponse plan;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
}
