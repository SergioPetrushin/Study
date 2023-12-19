package ru.study.study.mapper.educationplan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.entity.user.User;
import ru.study.study.mapper.user.UserResponseMapper;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EducationPlanResponseMapperTest {
    @Mock
    private UserResponseMapper userMapper;
    @InjectMocks
    private EducationPlanResponseMapper mapper;

    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @Test
    void from() {
        when(userMapper.from((User) any())).thenReturn(new UserResponse());

        var source = spy(getEducationPlan());

        var result = mapper.from(source);

        assertEquals(ID, result.getPlanId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());
        assertNotNull(result.getUser());

        verify(userMapper).from((User) any());
        verify(source).getId();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();
        verifyNoInteractions(userMapper, source);

    }

    @Test
    void fromList() {
        when(userMapper.from((User) any())).thenReturn(new UserResponse());

        var source = spy(getEducationPlan());

        var resultList = mapper.from(List.of(source, source, source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);


        assertEquals(ID, result.getPlanId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());
        assertNotNull(result.getUser());

        verify(userMapper, times(3)).from((User) any());
        verify(source, times(3)).getId();
        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getCreated();
        verify(source, times(3)).getModified();
        verifyNoInteractions(userMapper, source);
    }

    private EducationPlan getEducationPlan() {
        return new EducationPlan()
                .setDescription(DESCRIPTION)
                .setName(NAME)
                .setModified(MODIFIED)
                .setCreated(CREATED)
                .setId(ID);
    }
}
