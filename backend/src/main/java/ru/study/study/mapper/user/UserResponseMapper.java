package ru.study.study.mapper.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.entity.user.User;
import ru.study.study.mapper.Mapper;
import ru.study.study.mapper.userstatus.UserStatusResponseMapper;

@Service
@RequiredArgsConstructor
public class UserResponseMapper implements Mapper<UserResponse, User> {

    private final UserStatusResponseMapper userStatusResponseMapper;
    @Override
    public UserResponse from(User source) {
        return new UserResponse()
                .setUserId(source.getId())
                .setLogin(source.getLogin())
                .setFullName(source.getFullName())
                .setStatus(userStatusResponseMapper.from(source.getStatus()));
    }
}
