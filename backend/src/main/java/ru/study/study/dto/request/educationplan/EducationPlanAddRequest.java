package ru.study.study.dto.request.educationplan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.dto.request.task.TaskAddRequest;

import java.util.Collections;
import java.util.List;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class EducationPlanAddRequest {
    @Schema(description = "Имя плана")
    private String name;

    @Schema(description = "Описание плана")
    private String description;

    @Schema(description = "Задачи учебного плана")
    private List<TaskAddRequest> tasks = Collections.emptyList();
}
