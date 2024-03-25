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
@Schema(name = "ДТО задач добавления запроса")
public class TaskAddRequest {
    private Long taskId;
    private Long planId;
    private String name;
    private String description;
}
