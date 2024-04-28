package ru.study.study.entity.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskStatusTest extends BaseEntityTest {
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

        var taskStatus = getTaskStatus();
        var taskStatus2 = new TaskStatus(-ID);

        assertEquals(ID, taskStatus.getId());
        assertEquals(NAME, taskStatus.getName());
        assertEquals(CREATED, taskStatus.getCreated());
        assertEquals(MODIFIED, taskStatus.getModified());

        assertThat(taskStatus2.getId()).isEqualTo(-ID);

    }

    private TaskStatus getTaskStatus() {
        return new TaskStatus()
                .setId(ID)
                .setName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
