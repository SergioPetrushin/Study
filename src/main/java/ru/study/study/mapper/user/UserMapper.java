package ru.study.study.mapper.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.entity.user.User;
import ru.study.study.entity.user.UserStatus;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class UserMapper implements Mapper<User, UserAddRequest> {
    @Override
    public User from(UserAddRequest source) {
        return new User()
                .setLogin(source.getLogin())
                .setPassword(source.getPassword())
                .setFullName(source.getFullName())
                .setStatus(new UserStatus(source.getStatusId()))
                .setType(new UserType(source.getTypeId()));
    }
}
