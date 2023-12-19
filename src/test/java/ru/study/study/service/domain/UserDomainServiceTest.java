package ru.study.study.service.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import ru.study.study.dto.request.user.UserChangePWDRequest;
import ru.study.study.entity.user.User;
import ru.study.study.mapper.user.UserMapper;
import ru.study.study.mapper.user.UserMerger;
import ru.study.study.mapper.user.UserResponseMapper;
import ru.study.study.repository.UserRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserDomainServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private UserMerger userMerger;

    @InjectMocks
    private UserDomainService service;
    private static final Long ID = 1L;
    private static final String NAME = "NAME";

//    @Test
//    void changePWDTest1() {
//    when(userRepository.findUserByLogin(any())).thenReturn(Optional.of(getUser()));
//    var result = service.changePWD(getUserChangePWDRequest());
//        assertEquals("Пароль успешно изменен", result);
//        verify(userRepository).findUserByLogin(any());
//        verify(userRepository).save(any());
//        verifyNoMoreInteractions(userRepository);
//    }

    private User getUser(){
        return new User()
                .setId(ID);
    }

//    private UserChangePWDRequest getUserChangePWDRequest() {
//        return new UserChangePWDRequest()
//                .setLogin("test123")
//                .setPassword("asd132");
//    }
}
