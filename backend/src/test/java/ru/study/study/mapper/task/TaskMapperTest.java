package ru.study.study.mapper.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.task.TaskAddRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskMapperTest {
    @InjectMocks
    private TaskMapper mapper;

    private final static Long ID = 1L;
    private final static Integer ORDINAL = 1;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void from(){
        var source = spy(getTaskAddRequest());
        var result = mapper.from(source);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(ORDINAL, result.getOrdinal());
        assertNotNull(result.getPlan());

        verify(source).getPlanId();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getOrdinal();
        verifyNoMoreInteractions(source);

    }

    @Test
    void fromList(){
        var source = spy(getTaskAddRequest());
        var resultList = mapper.from(List.of(source, source,source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(ORDINAL, result.getOrdinal());
        assertNotNull(result.getPlan());

        verify(source, times(3)).getPlanId();
        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getOrdinal();
        verifyNoMoreInteractions(source);

    }

    private TaskAddRequest getTaskAddRequest(){
        return new TaskAddRequest()
                .setTaskId(ID)
                .setPlanId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setOrdinal(ORDINAL);
    }
}
