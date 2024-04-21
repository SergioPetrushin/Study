package ru.study.study.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserChangePWDRequest;
import ru.study.study.dto.request.user.UserRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.service.domain.UserDomainService;
import ru.study.study.service.utils.MailService;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDomainService userDomainService;
    @Mock
    private MailService mailService;

    @InjectMocks
    private UserService service;

    private static final Long ID = 1L;
    private static final String LOGIN = "login";
    private static final String PWD = "pwdPWD123@#$";
    private static final String NAME = "name";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);


    @Test
    void addUserTest() {

        when(userDomainService.addUser(any(), any())).thenReturn(ID);
        when(userDomainService.getUser(any())).thenReturn(getUserResponse());

        var response = service.addUser(getUserAddRequest());
/*
        assertEquals(ID, response.getUserId());
        assertEquals(NAME, response.getFullName());
        assertEquals(NAME, response.getLogin());
        assertEquals(ID, response.getStatus().getUserStatusId());
        */

        assertThat(response.getUserId()).isEqualTo(ID);
        assertThat(response.getFullName()).isEqualTo(NAME);
        assertThat(response.getLogin()).isEqualTo(NAME);
        assertThat(response.getStatus().getUserStatusId()).isEqualTo(ID);


        verify(userDomainService).addUser(any(), any());
        verify(userDomainService).getUser(any());
        verifyNoMoreInteractions(userDomainService);
    }


    @Test
    void getUserTest() {

        when(userDomainService.getUser(any())).thenReturn(getUserResponse());

        var response = service.getUser(new UserRequest());

        assertEquals(ID, response.getUserId());
        assertEquals(NAME, response.getFullName());
        assertEquals(NAME, response.getLogin());
        assertEquals(ID, response.getStatus().getUserStatusId());

        verify(userDomainService).checkLogin(any());
        verify(userDomainService).checkEmail(any());
        verify(userDomainService).getUser(any());
        verifyNoMoreInteractions(userDomainService);

    }

    @Test
    void changePWDTest1() {
        when(userDomainService.changePWD(any())).thenReturn("Пароль успешно изменен");

        var result = service.changePWD(getUserChangePWDRequest("asf123#$*FFF"));

        assertEquals("Пароль успешно изменен", result);

        verify(userDomainService).changePWD(any());

        verifyNoMoreInteractions(userDomainService);
    }

    @Test
    void changePWDTest2() {

        var result = service.changePWD(getUserChangePWDRequest("asd123"));

        assertEquals("Пароль не подходит. Пароль должен содержать не " +
                "менее 6 символов, спец символы, большие и маленькие буквы.", result);

        verifyNoMoreInteractions(userDomainService);
    }

    private UserResponse getUserResponse() {
        return new UserResponse()
                .setUserId(ID)
                .setStatus(new UserStatusResponse().setUserStatusId(ID))
                .setLogin(NAME)
                .setFullName(NAME);

    }

    private UserChangePWDRequest getUserChangePWDRequest(String pswd) {
        return new UserChangePWDRequest()
                .setLogin("test123")
                .setPassword(pswd);
    }

    private UserAddRequest getUserAddRequest() {
        return new UserAddRequest()
                .setStatusId(ID)
                .setPassword(PWD)
                .setMail("kjhads123@mail.ru");
    }
}
