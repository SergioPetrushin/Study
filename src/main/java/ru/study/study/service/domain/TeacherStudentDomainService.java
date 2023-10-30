package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.TeacherStudentRepository;

@Service
@RequiredArgsConstructor
public class TeacherStudentDomainService {
    private final TeacherStudentRepository teacherStudentRepository;
}
