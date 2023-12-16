package ru.study.study.mapper.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.entity.task.Task;
import ru.study.study.mapper.educationplan.EducationPlanResponseMapper;


import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskResponseMapperTest {
    @Mock
    private EducationPlanResponseMapper educationPlanResponseMapper;
    @InjectMocks
    private TaskResponseMapper mapper;

    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @Test
    void from() {
        when(educationPlanResponseMapper.from((EducationPlan) any())).thenReturn(new EducationPlanResponse());

        var source = spy(getTask());

        var result = mapper.from(source);

        assertEquals(ID, result.getTaskId());
        assertNotNull(result.getPlan());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(educationPlanResponseMapper).from((EducationPlan) any());
        verify(source).getId();
        verify(source).getPlan();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();
        verifyNoMoreInteractions(educationPlanResponseMapper, source);

    }

    @Test
    void fromList() {
        when(educationPlanResponseMapper.from((EducationPlan) any())).thenReturn(new EducationPlanResponse());

        var source = spy(getTask());

        var resultList = mapper.from(List.of(source, source, source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        assertEquals(ID, result.getTaskId());
        assertNotNull(result.getPlan());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(educationPlanResponseMapper, times(3)).from((EducationPlan) any());
        verify(source, times(3)).getId();
        verify(source, times(3)).getPlan();
        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getCreated();
        verify(source, times(3)).getModified();
        verifyNoMoreInteractions(educationPlanResponseMapper, source);
    }

    private Task getTask() {
        return new Task()
                .setId(ID)
                .setPlan(new EducationPlan(ID))
                .setName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setDescription(DESCRIPTION);
    }
}
