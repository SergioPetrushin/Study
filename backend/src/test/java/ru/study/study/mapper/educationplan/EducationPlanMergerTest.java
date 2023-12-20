package ru.study.study.mapper.educationplan;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.entity.enothers.EducationPlan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EducationPlanMergerTest {
    @InjectMocks
    private EducationPlanMerger merger;
    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void mergeTest() {
        var source = spy(getEducationPlanAddRequest());
        var result = merger.merge(new EducationPlan(), source);

        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);


    }

    private EducationPlanAddRequest getEducationPlanAddRequest() {
        return new EducationPlanAddRequest()
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
