package ru.study.study.mapper.userstatus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.entity.user.UserStatus;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class UserStatusMapper implements Mapper<UserStatus, UserStatusAddRequest> {
    @Override
    public UserStatus from(UserStatusAddRequest source) {
        return new UserStatus()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
