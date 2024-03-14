package ru.study.study.dto.request.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class UserLoginRequest {
    private String login;
    private String mail;
    private String pswd;
}
