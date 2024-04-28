package ru.study.study.entity.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;
import ru.study.study.entity.enothers.EducationPlan;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTest extends BaseEntityTest {
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private static final String PASSWORD = "PWD";
    private static final String LOGIN = "LOGIN";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @BeforeAll
    void init() throws ClassNotFoundException {
        super.checkCountFields(6);
    }

    @Test
    void testNoArgsConstructor() {

        var task = getTask();
        var task2 = new Task(-ID);

        assertEquals(ID, task.getId());
        assertEquals(NAME, task.getName());
        assertEquals(CREATED, task.getCreated());
        assertEquals(MODIFIED, task.getModified());

        assertThat(task2.getId()).isEqualTo(-ID);

    }

    private Task getTask() {
        return new Task()
                .setId(ID)
                .setPlan(new EducationPlan())
                .setName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
