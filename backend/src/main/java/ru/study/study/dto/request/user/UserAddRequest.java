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
@Schema(name = "ДТО добавления пользовательского запроса")
public class UserAddRequest {
    private Long userId;
    private String login;
    private String password;
    private String fullName;
    private Long typeId;
    private Long statusId;

}
