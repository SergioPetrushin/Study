package ru.study.study.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import ru.study.study.entity.user.User;
import ru.study.study.entity.user.UserType;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "TEACHER_STUDENTS")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TEACHER_STUDENTS_ID"))
public class TeacherStudent extends BaseEntity{
    @Serial
    private static final long serialVersionUID = 1L;

    public TeacherStudent(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEACHER_ID")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_ID")
    private User studentId;
    @Override
    public TeacherStudent setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public TeacherStudent setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public TeacherStudent setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
    
}
