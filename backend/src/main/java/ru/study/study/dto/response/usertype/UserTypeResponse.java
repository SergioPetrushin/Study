package ru.study.study.dto.response.usertype;

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
public class UserTypeResponse {
    @Schema(description = "ID типа пользователя ответ")
    private Long id;
    @Schema(description = "Имя типа пользователя ответ")
    private String name;
    @Schema(description = "Описание типа пользователя ответ")
    private String description;
    @Schema(description = "Время создания типа пользователя ответ")
    private LocalDateTime created;
    @Schema(description = "Время изменения типа пользователя ответ")
    private LocalDateTime modified;
}
