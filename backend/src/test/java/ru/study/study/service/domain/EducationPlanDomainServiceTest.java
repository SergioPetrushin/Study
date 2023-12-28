package ru.study.study.service.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.educationplan.EducationPlanAddRequest;
import ru.study.study.dto.response.educationplan.EducationPlanResponse;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.entity.enothers.EducationPlan;
import ru.study.study.mapper.educationplan.EducationPlanMapper;
import ru.study.study.mapper.educationplan.EducationPlanMerger;
import ru.study.study.mapper.educationplan.EducationPlanResponseMapper;
import ru.study.study.repository.EducationPlanRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EducationPlanDomainServiceTest {
    @Mock
    private EducationPlanRepository repository;
    @Mock
    private EducationPlanMapper educationPlanMapper;
    @Mock
    private EducationPlanMerger educationPlanMerger;
    @Mock
    private EducationPlanResponseMapper educationPlanResponseMapper;

    @InjectMocks
    private EducationPlanDomainService service;
    private static final Long ID = 1L;
    private static final String LOGIN = "login";
    private static final String PWD = "pwd";
    private static final String NAME = "name";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void addEducationPlanTest() {
        when(educationPlanMapper.from((EducationPlanAddRequest) any())).thenReturn(getEducationPlan());
        when(repository.save(any())).thenReturn(getEducationPlan());

        var result = service.addEducationPlan(new EducationPlanAddRequest());

        assertEquals(ID, result);

        verify(educationPlanMapper).from((EducationPlanAddRequest) any());
        verify(repository).save(any());
        verifyNoMoreInteractions(educationPlanMapper, educationPlanMerger,
                educationPlanResponseMapper, repository);


    }

    @Test
    void editEducationPlanTest() {
        when(repository.getReferenceById(any())).thenReturn(getEducationPlan());
        when(educationPlanMerger.merge(any(), any())).thenReturn(getEducationPlan());
        when(repository.save(any())).thenReturn(getEducationPlan());

        service.editEducationPlan(new EducationPlanAddRequest());

        verify(repository).getReferenceById(any());
        verify(repository).save(any());
        verify(educationPlanMerger).merge(any(), any());
        verifyNoMoreInteractions(educationPlanMapper, educationPlanMerger,
                educationPlanResponseMapper, repository);

    }

    @Test
    void getEducationPlanTest() {


        when(educationPlanResponseMapper.from((EducationPlan) any())).thenReturn(getEducationPlanResponse());
        when(repository.getReferenceById(any())).thenReturn(getEducationPlan());

        var result = service.getEducationPlan(ID);

        assertEquals(ID, result.getPlanId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());
        assertEquals(ID, result.getUser().getUserId());

        verify(educationPlanResponseMapper).from((EducationPlan) any());
        verify(repository).getReferenceById(any());
        verifyNoMoreInteractions(educationPlanMapper, educationPlanMerger,
                educationPlanResponseMapper, repository);

    }

    @Test
    void getAllEducationPlanTest() {

    }

    @Test
    void deleteEducationPlanTest() {

        service.deleteEducationPlan(ID);
        verify(repository).deleteById(ID);
        verifyNoMoreInteractions(educationPlanMapper, educationPlanMerger,
                educationPlanResponseMapper, repository);


    }

    private EducationPlan getEducationPlan() {
        return new EducationPlan()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setDescription(DESCRIPTION);
    }

    private EducationPlanResponse getEducationPlanResponse() {
        return new EducationPlanResponse()
                .setPlanId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setUser(new UserResponse().setUserId(ID));
    }
}
