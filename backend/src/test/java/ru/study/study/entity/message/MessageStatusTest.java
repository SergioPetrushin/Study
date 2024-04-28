package ru.study.study.entity.message;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;
import ru.study.study.entity.user.User;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageStatusTest extends BaseEntityTest {
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @BeforeAll
    void init() throws ClassNotFoundException {
        super.checkCountFields(5);
    }

    @Test
    void testNoArgsConstructor() {

        var messageStatus = getMessageStatus();
        var messageStatus2  = new MessageStatus(-ID);

        assertThat(messageStatus2.getId()).isEqualTo(-ID);

        assertThat(messageStatus.getId()).isEqualTo(ID);
        assertThat(messageStatus.getName()).isEqualTo(NAME);
        assertThat(messageStatus.getCreated()).isEqualTo(CREATED);
        assertThat(messageStatus.getModified()).isEqualTo(MODIFIED);

    }

    private MessageStatus getMessageStatus(){
        return new MessageStatus()
                .setId(ID)
                .setName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
