package ru.study.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.study.study.entity.FileDz;
@Repository
public interface FileDzRepository extends JpaRepository<FileDz, Long> {
}
