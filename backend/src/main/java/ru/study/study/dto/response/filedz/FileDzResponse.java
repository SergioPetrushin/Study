package ru.study.study.dto.response.filedz;

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
@Schema(name = "ДТО файлов ДЗ ответ")
public class FileDzResponse {
    private Long fileId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    // private StudentTaskResponse;
}
