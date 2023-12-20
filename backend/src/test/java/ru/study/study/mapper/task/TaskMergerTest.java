package ru.study.study.mapper.task;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.task.TaskAddRequest;
import ru.study.study.entity.task.Task;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TaskMergerTest {
    @InjectMocks
    private TaskMerger merger;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void mergeTest() {
        var source = spy(getTaskAddRequest());
        var result = merger.merge(new Task(ID), source);

        assertEquals(ID, result.getId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(ID, result.getPlan().getId());

        verify(source).getPlanId();
        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);
    }

    private TaskAddRequest getTaskAddRequest(){
        return new TaskAddRequest()
                .setTaskId(ID)
                .setPlanId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
