package ru.study.study.mapper.userstatus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.entity.user.UserStatus;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class UserStatusResponseMapper implements Mapper<UserStatusResponse, UserStatus> {

    @Override
    public UserStatusResponse from(UserStatus source) {
         return new UserStatusResponse()
                .setUserStatusId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
