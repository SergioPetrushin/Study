package ru.study.study.dto.response.filedz;

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
    private Long fileId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    // private StudentTaskResponse;

}
