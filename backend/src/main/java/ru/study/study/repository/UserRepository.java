package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.user.User;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
    boolean existsUsersByLogin(String login);
    boolean existsUsersByEmail(String mail);
    Optional<User> findUserByEmailCode(UUID code);

    boolean findUserByEmail(String mail);

    Optional<User> getUserByEmail(String mail);
    Optional<User> getUserByEmailCode(UUID code);
}
