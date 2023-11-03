package ru.study.study.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class UserResponse {

    private long userId;
    private String login;
    private String fullName;
    private UserStatusResponse status;
   // TODO private UserTypeResponse type;


}
