package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.task.StudentTask;
@Repository
public interface StudentTaskRepository extends JpaRepository<StudentTask, Long> {
}
