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
@Schema(name = "ДТО файлов ДЗ добавления запроса")
public class FileDzAddRequest {
    private Long fileId;
    private String name;
    private String description;
}
