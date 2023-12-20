package ru.study.study.mapper.userstatus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.entity.user.UserStatus;
import ru.study.study.mapper.Merger;

@Service
@RequiredArgsConstructor
public class UserStatusMerger implements Merger<UserStatus, UserStatusAddRequest> {
    @Override
    public UserStatus merge(UserStatus target, UserStatusAddRequest source) {
        return target
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
