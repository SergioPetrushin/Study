package ru.study.study.entity.task;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import ru.study.study.entity.BaseEntity;
import ru.study.study.entity.user.User;
import ru.study.study.entity.user.UserType;

import java.io.Serial;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "STUDENT_TASKS")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "STUDENT_TASK_ID"))
public class StudentTask extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    public StudentTask(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_ID")
    private User taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_STATUS_ID")
    private User taskStatusId;



    @Column(name = "EXPIRIED")
    private Timestamp exp;

    public void setExp(Timestamp exp) {
        this.exp = exp;
    }

    @Override
    public StudentTask setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public StudentTask setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
}
