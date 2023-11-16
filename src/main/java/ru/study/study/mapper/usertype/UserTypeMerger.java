package ru.study.study.mapper.usertype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.usertype.UserTypeAddRequest;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.Merger;

@Service
@RequiredArgsConstructor
public class UserTypeMerger implements Merger<UserType, UserTypeAddRequest> {

    @Override
    public UserType merge(UserType target, UserTypeAddRequest source) {
        return target
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
