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
@Schema(name = "ДТО пользовательских статусов ответ")
public class UserStatusResponse {

    private Long userStatusId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;

}
