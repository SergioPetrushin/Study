package ru.study.study.dto.response.task;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.entity.task.TaskStatusEnum;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class StudentTaskResponse {

    private Long id;
    private TaskResponse task;
    private TaskStatusEnum status;
    private LocalDateTime expired;
    private String solutions;
    private String comment;
    private Long assessment;
    private LocalDateTime created;
    private LocalDateTime modified;
}
