package ru.study.study.dto.request.filedz;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class FileDzAddRequest {
    @Schema(description = "ID файла")
    private Long fileId;
    @Schema(description = "Имя файла")
    private String name;
    @Schema(description = "Описание")
    private String description;
}
