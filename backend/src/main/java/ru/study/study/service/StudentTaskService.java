package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.ResponseBody;
import ru.study.study.service.domain.StudentTaskDomainService;

@Service
@RequiredArgsConstructor
public class StudentTaskService {
    private final StudentTaskDomainService service;

    public String changeStatusTask(Long id, Long statusId) {
        service.changeStatusTask(id, statusId);
        return "Статус успешно изменен!";
    }


}
