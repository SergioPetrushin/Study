package ru.study.study.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class UserAddRequest {

    private String login;
    private String password;
    private String fullName;
    private Long typeId;
    private Long statusId;

}
