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
@Schema(name = "ДТО запроса смены пароля")
public class UserChangePWDRequest {
    private String login;
    private String password;
}
