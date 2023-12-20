package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.task.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
