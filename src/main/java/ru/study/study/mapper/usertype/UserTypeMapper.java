package ru.study.study.mapper.usertype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.usertype.UserTypeAddRequest;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.Mapper;
@Service
@RequiredArgsConstructor
public class UserTypeMapper implements Mapper<UserType,UserTypeAddRequest> {

    @Override
    public UserType from(UserTypeAddRequest source) {
        return new UserType()
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
