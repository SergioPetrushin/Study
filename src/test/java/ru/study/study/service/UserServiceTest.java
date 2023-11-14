package ru.study.study.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.UserAddRequest;
import ru.study.study.dto.request.UserRequest;
import ru.study.study.dto.response.UserResponse;
import ru.study.study.dto.response.UserStatusResponse;
import ru.study.study.service.domain.UserDomainService;
import ru.study.study.service.domain.UserStatusDomainService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserDomainService userDomainService;

    @InjectMocks
    private UserService service;

    private static final Long ID = 1L;
    private static final String NAME = "NAME";


    @Test
    void addUserTest() {

        when(userDomainService.addUser(any())).thenReturn(ID);
        when(userDomainService.getUser(any())).thenReturn(getUserResponse());

        var response = service.addUser(new UserAddRequest());

        assertEquals(ID, response.getUserId());
        assertEquals(NAME, response.getFullName());
        assertEquals(NAME, response.getLogin());
        assertEquals(ID, response.getStatus().getUserStatusId());

        verify(userDomainService).addUser(any());
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


        verify(userDomainService).getUser(any());
        verifyNoMoreInteractions(userDomainService);

    }


    private UserResponse getUserResponse() {
        return new UserResponse()
                .setUserId(ID)
                .setStatus(new UserStatusResponse().setUserStatusId(ID))
                .setLogin(NAME)
                .setFullName(NAME);

    }

}
