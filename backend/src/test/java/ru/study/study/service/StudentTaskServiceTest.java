package ru.study.study.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.yaml.snakeyaml.events.Event;
import ru.study.study.dto.request.studenttask.StudentTaskAddRequest;
import ru.study.study.dto.response.studenttask.StudentTaskResponse;
import ru.study.study.entity.task.TaskStatusEnum;
import ru.study.study.service.domain.StudentTaskDomainService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentTaskServiceTest {

    @Mock
    private StudentTaskDomainService domainService;


    @InjectMocks
    private StudentTaskService service;

    private final Long STUDENT_TASK_ID = 0L;

    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "1,3", "2,1", "5,1", "3,4", "3,5"})
    void changeStatusSuccessTest(Long currentStatus, Long newStatus) {

        when(domainService.getStudentTask(anyLong())).thenReturn(getStudentTaskResponse(currentStatus));

        var result = service.changeStatusTask(STUDENT_TASK_ID, newStatus);

        assertThat(result).isEqualTo("Статус успешно изменен!");


        verify(domainService).getStudentTask(anyLong());
        verify(domainService).changeStatusTask(anyLong(), anyLong());
        verifyNoMoreInteractions(domainService);

    }

    @ParameterizedTest
    @CsvSource({
            "0,2", "0,3", "0,4", "0,5",
            "1,0", "1,0", "1,1", "1,4", "1,5",
            "2,0", "2,2", "2,3", "2,4", "2,5",
            "3,0", "3,0", "3,1", "3,2", "3,3",
            "4,0", "4,0", "4,1", "4,2", "4,3", "4,4", "4,5",
            "5,0", "5,2", "5,3", "5,4", "5,5" })
    void changeStatusFailedTest(Long currentStatus, Long newStatus) {

        when(domainService.getStudentTask(anyLong())).thenReturn(getStudentTaskResponse(currentStatus));

        var result = service.changeStatusTask(STUDENT_TASK_ID, newStatus);

        assertThat(result).isEqualTo("Смена статуса запрещена: " + TaskStatusEnum.getById(currentStatus) + " -> " + TaskStatusEnum.getById(newStatus));

        verify(domainService).getStudentTask(anyLong());
        verifyNoMoreInteractions(domainService);
    }

@Test
void addStudentTaskTest(){
        when(domainService.addStudentTask(any())).thenReturn(STUDENT_TASK_ID);
        when(domainService.getStudentTask(any())).thenReturn(new StudentTaskResponse());

      var result = service.addStudentTask(new StudentTaskAddRequest());
      assertThat(result).isNotNull();

      verify(domainService).addStudentTask(any());
      verify(domainService).getStudentTask(any());
      verifyNoMoreInteractions(domainService);
}
    private StudentTaskResponse getStudentTaskResponse(Long statusId) {
        return new StudentTaskResponse()
                .setId(STUDENT_TASK_ID)
                .setStatus(TaskStatusEnum.getById(statusId));
    }

}
