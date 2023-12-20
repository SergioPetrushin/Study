package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.user.UserStatus;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserStatusRepository extends JpaRepository<UserStatus, Long> {

    UserStatus getUserStatusByName(String name);
    Optional<UserStatus> findUserStatusByName(String name);

    boolean existsByCreated(LocalDateTime created);
    @Query(nativeQuery = true, value = "SELECT * FROM REPOSITORY.USER_STATUS WHERE CREATED > :created")
    UserStatus getCustomUserStatus(@Param("created")LocalDateTime created);

}
