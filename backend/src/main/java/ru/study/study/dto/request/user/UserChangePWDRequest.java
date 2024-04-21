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
public class UserChangePWDRequest {
    @Schema(description = "Изменение логина пользователя")
    private String login;
    @Schema(description = "Изменение пароля пользовател")
    private String password;
}
