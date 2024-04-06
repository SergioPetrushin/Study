package ru.study.study.dto.request.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.UUID;

@Data
@ToString
@EqualsAndHashCode
@Accessors(chain = true)
public class UserForgetPasswordMailRequest {
    private String mail;
    private String url;
    private UUID code;
    private String pwd;
}
