package ru.study.study.mapper.usertype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.Mapper;
@Service
@RequiredArgsConstructor
public class UserTypeRequestMapper implements Mapper<UserType, UserTypeRequest> {
    @Override
    public UserType from(UserTypeRequest source) {
        return new UserType()
                .setId(source.getTypeId());
    }
}
