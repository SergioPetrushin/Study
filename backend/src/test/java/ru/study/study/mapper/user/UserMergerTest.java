package ru.study.study.mapper.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.entity.user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserMergerTest {
    @InjectMocks
    private UserMerger merger;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";
    private final static String LOGIN = "kjhsdf";
    private final static String PASSWORD = "kjhsdf";
    private final static String FULLNAME = "kjhsdf";


    @Test
    void from() {
        var source = spy(getUserAddRequest());
        var result = merger.merge(new User(ID), source);

        assertEquals(LOGIN, result.getLogin());
        assertEquals(PASSWORD, result.getPassword());
        assertEquals(FULLNAME, result.getFullName());

        verify(source).getLogin();
        verify(source).getPassword();
        verify(source).getFullName();
        verifyNoMoreInteractions(source);
    }

    private UserAddRequest getUserAddRequest() {
        return new UserAddRequest()
                .setUserId(ID)
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .setFullName(FULLNAME)
                .setTypeId(ID)
                .setStatusId(ID);
    }
}
