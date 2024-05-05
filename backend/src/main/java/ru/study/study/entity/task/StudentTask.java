package ru.study.study.entity.task;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.entity.BaseEntity;
import ru.study.study.entity.user.User;

import java.io.Serial;
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
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TASK_STATUS_ID")
    private TaskStatus taskStatus;


    @Column(name = "EXPIRIED")
    private LocalDateTime expiried;

    @Column(name = "SOLUTION")
    private String solution;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "ASSESMENT")
    private Long assesment;

    @Override
    public StudentTask setId(Long id) {
        this.id = id;
        return this;
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
