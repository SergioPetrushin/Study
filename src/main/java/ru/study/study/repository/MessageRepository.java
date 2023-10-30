package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.message.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
