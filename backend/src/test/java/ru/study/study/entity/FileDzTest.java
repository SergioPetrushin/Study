package ru.study.study.entity;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileDzTest extends BaseEntityTest{
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @BeforeAll
    void init() throws ClassNotFoundException {
        super.checkCountFields(4);
    }

    @Test
    void testNoArgsConstructor() {
        var fileDz = getFileDz();
        var fileDz2 = new FileDz(-ID);

        assertEquals(ID, fileDz.getId());
        assertEquals(CREATED, fileDz.getCreated());
        assertEquals(MODIFIED, fileDz.getModified());
        assertEquals(NAME, fileDz.getName());

        assertThat(fileDz2.getId()).isEqualTo(-ID);
    }
    
    private FileDz getFileDz(){
        return new FileDz()
                .setId(ID)
                .setName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

}
