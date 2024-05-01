package ru.study.study.dto.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class TaskAddRequest {
    @Schema(description = "ID задачи")
    private Long taskId;
    @Schema(description = "ID плана")
    private Long planId;
    @Schema(description = "Имя задачи")
    private String name;
    @Schema(description = "Описание задачи")
    private String description;
    @Schema(description = "Порядковый номер учебного плана")
    private Integer ordinal;
}
