package ru.study.study.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherStudentTest extends BaseEntityTest{
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
    void testNoArgsConstructor(){

        var teacherStudent = getTeacherStudent();
        var teacherStudent2 = new TeacherStudent(-ID);

        assertEquals(ID, teacherStudent.getId());
        assertEquals(CREATED, teacherStudent.getCreated());
        assertEquals(MODIFIED, teacherStudent.getModified());

        // assertEquals(-ID, teacherStudent2.getId());
        assertThat(teacherStudent2.getId()).isEqualTo(-ID);

    }
    
    private TeacherStudent getTeacherStudent(){
        return new TeacherStudent()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
