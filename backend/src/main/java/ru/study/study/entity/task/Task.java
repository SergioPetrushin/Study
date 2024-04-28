package ru.study.study.entity.task;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import ru.study.study.entity.EntityWithName;
import ru.study.study.entity.enothers.EducationPlan;

import java.time.LocalDateTime;

@Entity(name = "TASK")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "TASK_ID"))
public class Task extends EntityWithName {
    public Task(Long id) {

        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAN_ID")
    private EducationPlan plan;

    @Override
    public Task setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Task setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Task setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public Task setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Task setDescription(String description) {
        this.description = description;
        return this;
    }
}
