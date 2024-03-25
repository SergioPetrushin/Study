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
@Schema(name = "ДТО пользовательского типа добавления запроса")
public class UserTypeAddRequest {
    private Long typeId;
    private String name;
    private String description;
}
