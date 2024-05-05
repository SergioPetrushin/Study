package ru.study.study.entity.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.study.study.entity.BaseEntityTest;
import ru.study.study.entity.user.User;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTaskTest extends BaseEntityTest {
    private final static Long ID = 1L;
    private final static String TEXT = "Text";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime EXPIRED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @BeforeAll
    void init() throws ClassNotFoundException {
        super.checkCountFields(7);
    }

    @Test
    void testNoArgsConstructor() {

        var studentTask = getStudentTask();
        var studentTask2 = new StudentTask(-ID);

        assertEquals(ID, studentTask.getId());
        assertEquals(EXPIRED, studentTask.getExp());
        assertEquals(CREATED, studentTask.getCreated());
        assertEquals(MODIFIED, studentTask.getModified());
        assertEquals(TEXT, studentTask.getSolution());
        assertEquals(TEXT, studentTask.getComment());
        assertEquals(ID, studentTask.getAssesment());

        assertThat(studentTask2.getId()).isEqualTo(-ID);

    }

    private StudentTask getStudentTask() {
        return new StudentTask()
                .setTaskId(new User())
                .setTaskStatusId(new User())
                .setId(ID)
                .setExp(EXPIRED)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setSolution(TEXT)
                .setComment(TEXT)
                .setAssesment(ID);

    }
}
