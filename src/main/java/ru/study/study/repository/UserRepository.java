package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.user.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
