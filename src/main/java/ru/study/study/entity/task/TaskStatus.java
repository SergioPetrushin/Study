package ru.study.study.entity.task;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.entity.EntityWithName;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "TASK_STATUS")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TASK_STATUS_ID"))
public class TaskStatus extends EntityWithName {

    @Serial
    private static final long serialVersionUID = 1L;

    public TaskStatus(Long id) {
        this.id = id;
    }

    @Override
    public TaskStatus setId(Long id) {
       this.id = id;
       return this;
    }

    @Override
    public TaskStatus setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public TaskStatus setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public TaskStatus setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TaskStatus setDescription(String description) {
        this.description = description;
        return this;
    }
}
