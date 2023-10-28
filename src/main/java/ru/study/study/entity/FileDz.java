package ru.study.study.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import ru.study.study.entity.user.UserType;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "FILES_DZ")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "FILE_ID"))
public class FileDz extends EntityWithName{
    @Serial
    private static final long serialVersionUID = 1L;

    public FileDz(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STUDENT_TASK_ID")
    private StudentTask taskId;



    @Override
    public FileDz setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public FileDz setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public FileDz setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public FileDz setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public FileDz setDescription(String description) {
        this.description = description;
        return this;
    }
}
