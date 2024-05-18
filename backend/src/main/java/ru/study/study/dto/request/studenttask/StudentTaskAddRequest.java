package ru.study.study.dto.request.studenttask;

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
public class StudentTaskAddRequest {
    @Schema(description = "Id ученика")
    private Long studentId;

    @Schema(description = "Id задачи")
    private Long taskId;

    @Schema(description = "Срок сдачи задачи")
    private LocalDateTime expired;
}
