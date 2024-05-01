package ru.study.study.dto.request.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class TaskRequest {
    @Schema(description = "ID задачи")
    private Long taskId;
}
