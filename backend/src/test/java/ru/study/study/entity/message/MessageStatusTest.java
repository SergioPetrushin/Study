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
    private static final String PASSWORD = "PWD";
    private static final String LOGIN = "LOGIN";
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

        assertEquals(ID, messageStatus.getId());
        assertEquals(NAME, messageStatus.getName());
        assertEquals(CREATED, messageStatus.getCreated());
        assertEquals(MODIFIED, messageStatus.getModified());

        assertThat(messageStatus2.getId()).isEqualTo(-ID);

    }

    private MessageStatus getMessageStatus(){
        return new MessageStatus()
                .setId(ID)
                .setName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
