package ru.study.study.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.userstatus.UserStatusAddRequest;
import ru.study.study.dto.request.userstatus.UserStatusRequest;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.service.domain.UserStatusDomainService;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserStatusServiceTest {

    @Mock
    private UserStatusDomainService userStatusDomainService;

    @InjectMocks
    private UserStatusService service;

    private static final Long ID = 1L;
    private static final String NAME = "NAME";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);


    @Test
    void addStatusTest() {

        when(userStatusDomainService.addUserStatus(any())).thenReturn(ID);
        when(userStatusDomainService.getUserStatus(ID)).thenReturn(getUserStatusResponse());

        var response = service.addStatus(new UserStatusAddRequest());

        assertEquals(ID, response.getUserStatusId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED, response.getCreated());
        assertEquals(MODIFIED, response.getModified());


        verify(userStatusDomainService).addUserStatus(any());
        verify(userStatusDomainService).getUserStatus(any());
        verifyNoMoreInteractions(userStatusDomainService);
    }

    @Test
    void editStatusTest() {

        when(userStatusDomainService.editUserStatus(any())).thenReturn(ID);
        when(userStatusDomainService.getUserStatus(ID)).thenReturn(getUserStatusResponse());

        var response = service.editStatus(new UserStatusAddRequest());

        assertEquals(ID, response.getUserStatusId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED, response.getCreated());
        assertEquals(MODIFIED, response.getModified());


        verify(userStatusDomainService).editUserStatus(any());
        verify(userStatusDomainService).getUserStatus(any());
        verifyNoMoreInteractions(userStatusDomainService);

    }

    @Test
    void getAllStatusTest() {


        when(userStatusDomainService.getAllUserStatus()).thenReturn(Collections.singletonList(getUserStatusResponse()));

        var responses = service.getAllUserStatus();

        assertFalse(responses.isEmpty());

        var response = responses.get(0);

        assertEquals(ID, response.getUserStatusId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED, response.getCreated());
        assertEquals(MODIFIED, response.getModified());


        verify(userStatusDomainService).getAllUserStatus();
        verifyNoMoreInteractions(userStatusDomainService);

    }

    @Test
    void deleteUserStatusTest() {

        service.deleteUserStatus(new UserStatusRequest());

        verify(userStatusDomainService).deleteUserStatus(any());
        verifyNoMoreInteractions(userStatusDomainService);
    }

    @Test
    void getUserStatusTest(){

        when(userStatusDomainService.getUserStatus(any())).thenReturn(getUserStatusResponse());

        var response = service.getUserStatus(new UserStatusRequest());

        assertEquals(ID, response.getUserStatusId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED, response.getCreated());
        assertEquals(MODIFIED, response.getModified());

        verify(userStatusDomainService).getUserStatus(any());
        verifyNoMoreInteractions(userStatusDomainService);
    }

    private UserStatusResponse getUserStatusResponse() {
        return new UserStatusResponse()
                .setUserStatusId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

}
