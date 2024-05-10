package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.ResponseBody;
import ru.study.study.entity.task.TaskStatusEnum;
import ru.study.study.service.domain.StudentTaskDomainService;

import java.util.Collections;
import java.util.List;

import static ru.study.study.entity.task.TaskStatusEnum.*;

@Service
@RequiredArgsConstructor
public class StudentTaskService {
    private final StudentTaskDomainService service;


    public String changeStatusTask(Long id, Long statusId) {
        var currentStatus = service.getStudentTask(id).getStatus();
        var newStatus = TaskStatusEnum.getById(statusId);
        var acceptableStatuses = switch (currentStatus) {
            case CREATED, CHANGED, COMPLETED -> Collections.emptyList();
            case ISSUED, QUESTION, REJECTED -> List.of(IN_WORK);
            case IN_WORK -> List.of(QUESTION, ON_CHECK);
            case ON_CHECK -> List.of(COMPLETED, REJECTED);
        };
        if(acceptableStatuses.contains(newStatus)){
            service.changeStatusTask(id, statusId);
            return "Статус успешно изменен!";
        } else {
            return "Смена статуса запрещена: "+currentStatus+ " -> "+newStatus;
        }
    }

}
