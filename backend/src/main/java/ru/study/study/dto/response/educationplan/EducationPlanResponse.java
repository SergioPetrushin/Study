package ru.study.study.dto.response.educationplan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.dto.response.task.TaskResponse;
import ru.study.study.dto.response.user.UserResponse;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class EducationPlanResponse {
    @Schema(description = "ID плана ответа")
    private Long planId;
    @Schema(description = "Имя плана ответа")
    private String name;
    @Schema(description = "Описание плана ответа")
    private String description;
    @Schema(description = "Объект пользователя")
    private UserResponse user;
    @Schema(description = "Время создания")
    private LocalDateTime created;
    @Schema(description = "Время изменения")
    private LocalDateTime modified;
    @Schema( description = "Задачи плана")
    private List<TaskResponse> tasks;

}
