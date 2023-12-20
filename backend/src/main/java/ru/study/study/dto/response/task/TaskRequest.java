package ru.study.study.dto.response.task;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class TaskRequest {
    private Long taskId;
}
