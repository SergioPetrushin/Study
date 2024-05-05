package ru.study.study.dto.response.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class StudentTaskResponse {
    @Schema(description = "ID задачи ответа")
    private Long taskStatusId;
}
