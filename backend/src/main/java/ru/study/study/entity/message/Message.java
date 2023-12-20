package ru.study.study.entity.message;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import ru.study.study.entity.BaseEntity;
import ru.study.study.entity.user.User;

import java.io.Serial;
import java.time.LocalDateTime;

@Entity(name = "MESSAGE")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@ToString(onlyExplicitlyIncluded = true, callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AttributeOverride(name = "id", column = @Column(name = "MESSAGE_ID"))
public class Message extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    public Message(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TO")
    private User placeTo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FROM")
    private User placeFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MESSAGE_STATUS_ID")
    private MessageStatus messageStatusId;

    @Column(name = "TEXT")
    private String text;

    @Override
    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public Message setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    @Override
    public Message setModified(LocalDateTime modified) {
        this.modified = modified;
        return this;
    }
    
}
