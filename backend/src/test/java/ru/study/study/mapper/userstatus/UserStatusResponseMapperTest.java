package ru.study.study.mapper.userstatus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.entity.user.UserStatus;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserStatusResponseMapperTest {
    @InjectMocks
    private UserStatusResponseMapper mapper;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @Test
    void from() {
        var source = spy(getUserStatus());
        var result = mapper.from(source);

        assertEquals(ID, result.getUserStatusId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(source).getId();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();
        verifyNoMoreInteractions(source);


    }

    @Test
    void fromList() {
        var source = spy(getUserStatus());
        var resultList = mapper.from(List.of(source, source, source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        assertEquals(ID, result.getUserStatusId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(source, times(3)).getId();
        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getCreated();
        verify(source, times(3)).getModified();
        verifyNoMoreInteractions(source);
    }

    private UserStatus getUserStatus() {
        return new UserStatus()
                .setId(ID)
                .setName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setDescription(DESCRIPTION);
    }
}
