package ru.study.study.entity.user;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import ru.study.study.entity.EntityWithName;

import java.time.LocalDateTime;

@Entity(name = "USER_TYPE")
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_TYPE_ID"))
public class UserType extends EntityWithName {
    public UserType(long id) {
        this.id = id;
    }

    @Override
    public UserType setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserType setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public UserType setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public UserType setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserType setDescription(String description) {
        this.description = description;
        return this;
    }
}
