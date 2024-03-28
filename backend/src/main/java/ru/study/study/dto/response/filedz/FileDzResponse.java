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
public class FileDzResponse {
    @Schema(description = "ID файла ДЗ ответа")
    private Long fileId;
    @Schema(description = "Имя файла ДЗ ответа")
    private String name;
    @Schema(description = "Описание файла ДЗ ответа")
    private String description;
    @Schema(description = "Время создания файла ДЗ ответа")
    private LocalDateTime created;
    @Schema(description = "Время изменения файла ДЗ ответа")
    private LocalDateTime modified;
    // private StudentTaskResponse;
}
