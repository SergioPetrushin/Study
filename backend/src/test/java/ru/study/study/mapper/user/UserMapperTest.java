package ru.study.study.mapper.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.user.UserAddRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserMapperTest {
    @InjectMocks
    private UserMapper mapper;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";
    private final static String LOGIN = "lkjFFFds132";
    private final static String PASSWORD = "lkjFFFds132";


    @Test
    void from() {
        var source = spy(getUserAddRequest());
        var result = mapper.from(source);

        assertEquals(LOGIN, result.getLogin());
        assertEquals(PASSWORD, result.getPassword());
        assertEquals(NAME, result.getFullName());
        assertNotNull(result.getStatus());
        assertNotNull(result.getType());

        verify(source).getStatusId();
        verify(source).getTypeId();
        verify(source).getLogin();
        verify(source).getPassword();
        verify(source).getFullName();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList() {
        var source = spy(getUserAddRequest());
        var resultList = mapper.from(List.of(source, source,source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        assertEquals(LOGIN, result.getLogin());
        assertEquals(PASSWORD, result.getPassword());
        assertEquals(NAME, result.getFullName());
        assertNotNull(result.getStatus());
        assertNotNull(result.getType());

        verify(source, times(3)).getStatusId();
        verify(source, times(3)).getTypeId();
        verify(source, times(3)).getLogin();
        verify(source, times(3)).getPassword();
        verify(source, times(3)).getFullName();
        verifyNoMoreInteractions(source);
    }

    private UserAddRequest getUserAddRequest() {
        return new UserAddRequest()
                .setUserId(ID)
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .setFullName(NAME)
                .setTypeId(ID)
                .setStatusId(ID);
    }
}
