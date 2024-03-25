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
@Schema(name = "ДТО статусов сообщений запрос")
public class MessageStatusRequest {
    private Long messageStatusId;
}
