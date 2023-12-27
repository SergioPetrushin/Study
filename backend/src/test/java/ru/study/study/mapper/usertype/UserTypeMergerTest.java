package ru.study.study.mapper.usertype;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.usertype.UserTypeAddRequest;
import ru.study.study.entity.user.UserType;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserTypeMergerTest {
    @InjectMocks
    private UserTypeMerger merger;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void from() {
        var source = spy(getUserTypeAddRequest());
        var result = merger.merge(new UserType(ID), source);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);

    }



    private UserTypeAddRequest getUserTypeAddRequest() {
        return new UserTypeAddRequest()
                .setTypeId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
