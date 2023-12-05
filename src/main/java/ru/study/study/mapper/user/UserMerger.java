package ru.study.study.mapper.user;

import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.entity.user.User;
import ru.study.study.mapper.Merger;

public class UserMerger implements Merger<User, UserAddRequest> {
    @Override
    public User merge(User target, UserAddRequest source) {
        return target
                .setLogin(source.getLogin())
                .setPassword(source.getPassword())
                .setFullName(source.getFullName());
    }
}
