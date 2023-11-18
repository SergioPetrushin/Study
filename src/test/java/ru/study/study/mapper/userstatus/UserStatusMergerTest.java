package ru.study.study.mapper.userstatus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.entity.user.UserStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class UserStatusMergerTest {

    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @InjectMocks
    private UserStatusMerger merger;

    @Test
    void mergeTest(){

        var source = spy(getUserStatusAddRequest());

        var result = merger.merge(new UserStatus(ID), source);

        assertEquals(ID, result.getId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);

    }

    private UserStatusAddRequest getUserStatusAddRequest() {

        return new UserStatusAddRequest()
                .setStatusId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);

    }
}
