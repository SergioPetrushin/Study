package ru.study.study.dto.response.educationplan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.dto.response.user.UserResponse;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
@Schema(name = "ДТО обучающего плана ответ")

public class EducationPlanResponse {
    private Long planId;
    private String name;
    private String description;
    private UserResponse user;
    private LocalDateTime created;
    private LocalDateTime modified;

}
