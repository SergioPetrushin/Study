package ru.study.study.entity.message;

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

@Entity(name = "MESSAGE_STATUS")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "MESSAGE_STATUS_ID"))
public class MessageStatus extends EntityWithName {
    @Serial
    private static final long serialVersionUID = 1L;

    public MessageStatus(long id) {
        this.id = id;
    }

    @Override
    public MessageStatus setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public MessageStatus setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public MessageStatus setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }

    @Override
    public MessageStatus setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public MessageStatus setDescription(String description) {
        this.description = description;
        return this;
    }
}
