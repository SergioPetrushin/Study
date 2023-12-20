package ru.study.study.entity.enothers;

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
import ru.study.study.entity.EntityWithName;
import ru.study.study.entity.user.User;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "EDUCATION_PLAN")
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "PLAN_ID"))
public class EducationPlan extends EntityWithName {
  
    @Serial
    private static final long serialVersionUID = 1L;
    public EducationPlan(long id) {

        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Override
    public EducationPlan setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public EducationPlan setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public EducationPlan setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public EducationPlan setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public EducationPlan setDescription(String description) {
        this.description = description;
        return this;
    }
}
