package ru.study.study.mapper.studenttask;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.studenttask.StudentTaskAddRequest;
import ru.study.study.entity.task.TaskStatus;
import ru.study.study.entity.task.TaskStatusEnum;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentTaskMapperTest {
    @InjectMocks
    private StudentTaskMapper mapper;
    private final static Long ID = 1L;
private final static LocalDateTime EXPIRIED = LocalDateTime.now();

    @Test
    void from(){
        var source = spy(getStudentTaskAddRequest());
        var result = mapper.from(source);

        Assertions.assertThat(result.getId()).isNull();
        Assertions.assertThat(result.getUser().getId()).isEqualTo(ID);

        Assertions.assertThat(result.getTask().getId()).isEqualTo(ID);

        Assertions.assertThat(result.getExpiried()).isEqualTo(EXPIRIED);

        Assertions.assertThat(result.getTaskStatus().getId()).isEqualTo(TaskStatusEnum.ISSUED.getId());

        verify(source).getStudentId();
        verify(source).getTaskId();
        verify(source).getExpired();
        verifyNoMoreInteractions(source);

    }

    @Test
    void fromList(){
        var source = spy(getStudentTaskAddRequest());
        var resultList = mapper.from(List.of(source, source,source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        Assertions.assertThat(result.getId()).isNull();
        Assertions.assertThat(result.getUser().getId()).isEqualTo(ID);

        Assertions.assertThat(result.getTask().getId()).isEqualTo(ID);

        Assertions.assertThat(result.getExpiried()).isEqualTo(EXPIRIED);

        Assertions.assertThat(result.getTaskStatus().getId()).isEqualTo(TaskStatusEnum.ISSUED.getId());

        verify(source, times(3)).getStudentId();
        verify(source, times(3)).getTaskId();
        verify(source, times(3)).getExpired();
        verifyNoMoreInteractions(source);

    }

    private StudentTaskAddRequest getStudentTaskAddRequest(){
        return new StudentTaskAddRequest()
                .setStudentId(ID)
                .setTaskId(ID)
                .setExpired(EXPIRIED);
    }
}
