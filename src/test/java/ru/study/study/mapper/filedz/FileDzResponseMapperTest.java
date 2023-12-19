package ru.study.study.mapper.filedz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.entity.FileDz;

import java.time.LocalDateTime;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FileDzResponseMapperTest {
    @InjectMocks
    private FileDzResponseMapper mapper;

    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @Test
    void from() {
        var source = spy(getFileDz());

        var result = mapper.from(source);

        assertEquals(ID, result.getFileId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(source).getId();
        verify(source).getName();
        verify(source).getDescription();
        verify(source).getCreated();
        verify(source).getModified();


    }

    @Test
    void fromList() {
        var source = spy(getFileDz());

        var resultList = mapper.from(List.of(source, source, source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        assertEquals(ID, result.getFileId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(source, times(3)).getId();
        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getCreated();
        verify(source, times(3)).getModified();

    }

    private FileDz getFileDz() {
        return new FileDz()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
