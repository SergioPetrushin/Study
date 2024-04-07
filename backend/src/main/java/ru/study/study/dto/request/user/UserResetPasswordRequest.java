package ru.study.study.dto.request.user;

import lombok.Data;

import java.util.UUID;

@Data
public class UserResetPasswordRequest {

    private UUID code;
    private String password;

}
