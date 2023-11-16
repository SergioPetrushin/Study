package ru.study.study.dto.response.usertype;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class UserTypeResponse {
    private Long userTypeId;
    private String name;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
}
