package ru.study.study.mapper.educationplan;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EducationPlanMapperTest {
    @InjectMocks
    private EducationPlanMapper mapper;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void from(){
        var source = spy(getEducationPlanAddRequest());
        var result = mapper.from(source);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);
    }

    @Test
    void fromList(){
        var source = spy(getEducationPlanAddRequest());
        var resultList = mapper.from(List.of(source, source, source));
        assertEquals(3, resultList.size());
        var result = resultList.get(0);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source, times(3)).getName();
        verify(source, times(3)).getDescription();
        verifyNoMoreInteractions(source);
    }
private EducationPlanAddRequest getEducationPlanAddRequest(){
        return new EducationPlanAddRequest()
                .setName(NAME)
                .setUserId(ID)
                .setDescription(DESCRIPTION);
}
}
