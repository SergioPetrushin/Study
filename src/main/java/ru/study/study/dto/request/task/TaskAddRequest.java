package ru.study.study.dto.request.task;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class TaskAddRequest {
    private String name;
    private Long planId;

}
