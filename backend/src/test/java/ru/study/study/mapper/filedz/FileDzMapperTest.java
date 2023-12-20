package ru.study.study.mapper.filedz;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.filedz.FileDzAddRequest;
import ru.study.study.mapper.filedz.FileDzMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FileDzMapperTest {
    @InjectMocks
    private FileDzMapper mapper;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void from(){
        var source = spy(getFileDzAddRequest());
        var result = mapper.from(source);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source).getName();
        verify(source).getDescription();
        verify(source).getFileId();
        verifyNoMoreInteractions(source);

    }

    @Test
    void fromList(){
        var source = spy(getFileDzAddRequest());
        var resultList = mapper.from(List.of(source, source,source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);


        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verify(source, times(3)).getFileId();
        verifyNoMoreInteractions(source);
    }
    private FileDzAddRequest getFileDzAddRequest(){
        return new FileDzAddRequest()
                .setFileId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
