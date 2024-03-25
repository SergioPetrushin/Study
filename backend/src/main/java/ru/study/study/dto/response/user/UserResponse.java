package ru.study.study.dto.response.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.dto.response.userstatus.UserStatusResponse;

@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
@Schema(name = "ДТО пользовательского ответ")
public class UserResponse {

    @Schema(description = "ID пользователя")
    private long userId;
    @Schema(description = "Логин пользователя")
    private String login;
    @Schema(description = "ФИО пользователя")
    private String fullName;
    @Schema(description = "Статус пользователя")
    private UserStatusResponse status;
   // TODO private UserTypeResponse type;


}
