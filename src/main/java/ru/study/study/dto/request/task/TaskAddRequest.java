package ru.study.study.dto.request.task;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class TaskAddRequest {
    private Long taskId;
    private Long planId;
    private String name;
    private String description;
}
