package ru.study.study.dto.request.userstatus;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class UserStatusAddRequest {
    private Long statusId; 
    private String name;
    private String description;
}
