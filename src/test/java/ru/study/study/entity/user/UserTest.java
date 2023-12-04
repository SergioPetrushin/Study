package ru.study.study.entity.user;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserTest extends BaseEntityTest {


    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private static final String PASSWORD = "PWD";
    private static final String LOGIN = "LOGIN";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);



    @BeforeAll
    void init() throws ClassNotFoundException {
        super.checkCountFields(8);
    }

    @Test
    void testNoArgsConstructor(){

        var user = getUser();
        var user2 = new User(-ID);

        assertEquals(ID, user.getId());
        assertEquals(NAME, user.getFullName());
        assertEquals(LOGIN, user.getLogin());
        assertEquals(PASSWORD, user.getPassword());
        assertEquals(ID, user.getType().getId());
        assertEquals(ID, user.getStatus().getId());
        assertEquals(CREATED, user.getCreated());
        assertEquals(MODIFIED, user.getModified());

        assertEquals(-ID, user2.getId());

    }


    private User getUser(){
        return new User()
                .setId(ID)
                .setLogin(LOGIN)
                .setPassword(PASSWORD)
                .setFullName(NAME)
                .setType(new UserType(ID))
                .setStatus(new UserStatus(ID))
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

}
