package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByLogin(String login);
    boolean existsUsersByLogin(String login);
    boolean existsUsersByEmail(String mail);

    @Query(value = "SELECT password FROM users WHERE email = ?1", nativeQuery = true)
    String findPasswordByEmail(String email);

    @Query(value = "SELECT password FROM users WHERE login = ?1", nativeQuery = true)
    String findPasswordByLogin(String login);
}
