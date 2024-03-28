package ru.study.study.dto.response.userstatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class UserStatusResponse {
    @Schema(description = "ID статуса пользователя ответа")
    private Long userStatusId;
    @Schema(description = "Имя пользователя ответа")
    private String name;
    @Schema(description = "Описание пользователя ответа")
    private String description;
    @Schema(description = "Время создания пользователя ответа")
    private LocalDateTime created;
    @Schema(description = "Время изменения пользователя ответа")
    private LocalDateTime modified;

}
