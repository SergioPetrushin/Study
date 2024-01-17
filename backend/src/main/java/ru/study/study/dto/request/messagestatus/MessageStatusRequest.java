package ru.study.study.dto.request.messagestatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class MessageStatusRequest {
    private Long messageStatusId;
}
