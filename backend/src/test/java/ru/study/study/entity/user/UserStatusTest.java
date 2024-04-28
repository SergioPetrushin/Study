package ru.study.study.entity.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserStatusTest extends BaseEntityTest {
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
        var userStatus = getUserStatus();
        var userStatus2 = new UserStatus(-ID);

        assertEquals(ID, userStatus.getId());
        assertEquals(CREATED, userStatus.getCreated());
        assertEquals(MODIFIED, userStatus.getModified());
        assertEquals(NAME, userStatus.getName());

        assertThat(userStatus2.getId()).isEqualTo(-ID);
    }

    private UserStatus getUserStatus() {
        return new UserStatus()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setName(NAME);

    }
}
