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
public class MessageStatusResponse {
    @Schema(description = "ID статуса сообщения")
    private Long messageStatusId;
    @Schema(description = "Имя статуса сообщения ответа")
    private String name;
    @Schema(description = "Описания статуса сообщения ответа")
    private String description;
    @Schema(description = "Время создания статуса сообщения ответа")
    private LocalDateTime created;
    @Schema(description = "Время изменения статуса сообщения ответа")
    private LocalDateTime modified;


}
