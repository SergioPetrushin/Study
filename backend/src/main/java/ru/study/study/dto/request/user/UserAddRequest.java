package ru.study.study.dto.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class UserAddRequest {
    @Schema(description = "ID пользователя")
    private Long userId;
    @Schema(description = "Логин пользователя")
    private String login;
    @Schema(description = "Пароль пользователя")
    private String password;
    @Schema(description = "Имя пользователя")
    private String fullName;
    @Schema(description = "Тип ID")
    private Long typeId;
    @Schema(description = "Статус ID")
    private Long statusId;

}
