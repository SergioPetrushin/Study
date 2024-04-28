package ru.study.study.entity.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTypeTest extends BaseEntityTest {
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
        var userType = getUserType();
        var userType2 = new UserType(-ID);

        assertEquals(ID, userType.getId());
        assertEquals(CREATED, userType.getCreated());
        assertEquals(MODIFIED, userType.getModified());
        assertEquals(NAME, userType.getName());

        assertThat(userType2.getId()).isEqualTo(-ID);
    }

    private UserType getUserType() {
        return new UserType()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setName(NAME);

    }
}
