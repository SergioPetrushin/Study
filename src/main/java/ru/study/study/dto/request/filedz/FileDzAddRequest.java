package ru.study.study.dto.request.filedz;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class FileDzAddRequest {
    private Long fileId;
    private String name;
    private String description;
}
