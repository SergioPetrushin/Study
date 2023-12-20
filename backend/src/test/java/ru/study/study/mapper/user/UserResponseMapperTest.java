package ru.study.study.mapper.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.entity.user.User;
import ru.study.study.entity.user.UserStatus;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.userstatus.UserStatusResponseMapper;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserResponseMapperTest {

    @Mock
    private UserStatusResponseMapper userStatusResponseMapper;

    @InjectMocks
    private UserResponseMapper mapper;


    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private static final String PASSWORD = "PWD";
    private static final String LOGIN = "LOGIN";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);


    @Test
    void from(){

        when(userStatusResponseMapper.from((UserStatus) any())).thenReturn(new UserStatusResponse());

        User source = spy(getUser());

        var result = mapper.from(source);

        assertEquals(ID, result.getUserId());
        assertEquals(LOGIN, result.getLogin());
        assertEquals(NAME, result.getFullName());
        assertNotNull(result.getStatus());


        verify(userStatusResponseMapper).from((UserStatus)any());
        verify(source).getId();
        verify(source).getLogin();
        verify(source).getFullName();
        verify(source).getStatus();
        verifyNoMoreInteractions(userStatusResponseMapper, source);


    }

    @Test
    void fromList(){

        when(userStatusResponseMapper.from((UserStatus) any())).thenReturn(new UserStatusResponse());

        User source = spy(getUser());

        var resultList = mapper.from(List.of(source,source,source));

        assertEquals(3, resultList.size());

        var result = resultList.get(0);

        assertEquals(ID, result.getUserId());
        assertEquals(LOGIN, result.getLogin());
        assertEquals(NAME, result.getFullName());
        assertNotNull(result.getStatus());


        verify(userStatusResponseMapper, times(3)).from((UserStatus)any());
        verify(source, times(3)).getId();
        verify(source, times(3)).getLogin();
        verify(source, times(3)).getFullName();
        verify(source, times(3)).getStatus();
        verifyNoMoreInteractions(userStatusResponseMapper, source);



    }

    private User getUser(){
            return new User()
                    .setId(ID)
                    .setLogin(LOGIN)
                    .setPassword(PASSWORD)
                    .setFullName(NAME)
                    .setType(new UserType(ID))
                    .setStatus(new UserStatus(ID))
                    .setCreated(CREATED)
                    .setModified(MODIFIED);
        }
    }

