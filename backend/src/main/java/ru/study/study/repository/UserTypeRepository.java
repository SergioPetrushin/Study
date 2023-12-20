package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.user.UserType;
@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
