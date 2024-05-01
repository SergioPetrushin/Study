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
public class TaskResponse {
    @Schema(description = "ID задачи ответа")
    private Long taskId;
    @Schema(description = "План ответ")
    private EducationPlanResponse plan;
    @Schema(description = "Имя задачи ответа")
    private String name;
    @Schema(description = "Описание задачи ответа")
    private String description;
    @Schema(description = "Время создания задачи ответ")
    private LocalDateTime created;
    @Schema(description = "Время изменения задачи ответ")
    private LocalDateTime modified;
    @Schema(description = "Порядковый номер учебного плана")
    private Integer ordinal;
}
