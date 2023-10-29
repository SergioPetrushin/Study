package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.task.TaskStatus;
@Repository
public interface TaskStatusRepository extends JpaRepository<TaskStatus, Long> {
}
