package ru.study.study.dto.response.task;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(name = "ДТО задач добавления ответ")
public class TaskResponse {
    private Long taskId;
    private EducationPlanResponse plan;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
}
