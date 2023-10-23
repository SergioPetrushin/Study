package ru.study.study.entity.user;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import ru.study.study.entity.EntityWithName;


import java.time.LocalDateTime;


@Entity(name = "USER_STATUS")
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_STATUS_ID"))
public class UserStatus extends EntityWithName {
    public UserStatus(long id) {
        this.id = id;
    }

    @Override
    public UserStatus setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public UserStatus setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public UserStatus setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public UserStatus setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public UserStatus setDescription(String description) {
        this.description = description;
        return this;
    }
}
