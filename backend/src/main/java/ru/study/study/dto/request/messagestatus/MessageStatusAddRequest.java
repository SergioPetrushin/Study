package ru.study.study.dto.request.messagestatus;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
@Schema(name = "ДТО статусов сообщений добавления запроса")
public class MessageStatusAddRequest {
    private Long messageStatusId;
    private String name;
    private String description;

}
