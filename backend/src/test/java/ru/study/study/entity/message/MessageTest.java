package ru.study.study.entity.message;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;
import ru.study.study.entity.user.User;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest extends BaseEntityTest {
    private final static Long ID = 1L;
    private static final String TEXT = "TEXT";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @BeforeAll
    void init() throws ClassNotFoundException {
        super.checkCountFields(7);
    }

    @Test
    void testNoArgsConstructor() {
        var message = getMessage();
        var message2 = new Message(-ID);

        assertEquals(ID, message.getId());
        assertEquals(TEXT, message.getText());
        assertEquals(CREATED, message.getCreated());
        assertEquals(MODIFIED, message.getModified());

        assertThat(message2.getId()).isEqualTo(-ID);

    }

    private Message getMessage() {
        return new Message()
                .setId(ID)
                .setMessageStatusId(new MessageStatus())
                .setPlaceTo(new User())
                .setPlaceFrom(new User())
                .setText(TEXT)
                .setCreated(CREATED)
                .setModified(MODIFIED);

    }
}
