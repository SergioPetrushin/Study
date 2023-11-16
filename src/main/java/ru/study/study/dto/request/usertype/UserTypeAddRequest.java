package ru.study.study.dto.request.usertype;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class UserTypeAddRequest {
    private Long typeId;
    private String name;
    private String description;
}
