package ru.study.study.dto.response.messagestatus;

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
@Schema(name = "ДТО статусов сообщений ответ")
public class MessageStatusResponse {
    private Long messageStatusId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;


}
