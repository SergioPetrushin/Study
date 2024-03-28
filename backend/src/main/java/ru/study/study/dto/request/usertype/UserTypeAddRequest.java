package ru.study.study.dto.request.usertype;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class UserTypeAddRequest {
    @Schema(description = "ID типа пользователя")
    private Long typeId;
    @Schema(description = "Имя типа пользователя")
    private String name;
    @Schema(description = "Описание типа пользователя")
    private String description;
}
