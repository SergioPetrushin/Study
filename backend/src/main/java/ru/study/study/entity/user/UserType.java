package ru.study.study.entity.user;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import ru.study.study.entity.EntityWithName;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Entity(name = "USER_TYPE")
@Getter
@Setter
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "USER_TYPE_ID"))
public class UserType extends EntityWithName {
    @Serial
    private static final long serialVersionUID = 1L;
    public UserType(long id) {
        this.id = id;
    }

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
//    private List<User> users = Collections.emptyList();


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
