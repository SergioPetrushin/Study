package ru.study.study.mapper.userstatus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserStatusMapperTest {
    @InjectMocks
    private UserStatusMapper mapper;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void from() {
        var source = spy(getUserStatusAddRequest());
        var result = mapper.from(source);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList() {
        var source = spy(getUserStatusAddRequest());
        var resultList  = mapper.from(List.of(source, source,source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verifyNoMoreInteractions(source);
    }

    private UserStatusAddRequest getUserStatusAddRequest() {
        return new UserStatusAddRequest()
                .setStatusId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
