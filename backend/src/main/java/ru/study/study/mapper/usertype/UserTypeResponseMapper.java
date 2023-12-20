package ru.study.study.mapper.usertype;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class UserTypeResponseMapper implements Mapper<UserTypeResponse, UserType>{


    @Override
    public UserTypeResponse from(UserType source) {
        return new UserTypeResponse()
                .setUserTypeId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
