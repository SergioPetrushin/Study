package ru.study.study.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.messagestatus.MessageStatusAddRequest;
import ru.study.study.dto.request.messagestatus.MessageStatusRequest;
import ru.study.study.dto.response.messagestatus.MessageStatusResponse;
import ru.study.study.service.domain.MessageStatusDomainService;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageStatusServiceTest {
    @Mock
    private MessageStatusDomainService messageStatusDomainService;

    @InjectMocks
    private MessageStatusService messageStatusService;

    private static final Long ID = 1L;
    private static final String LOGIN = "login";
    private static final String PWD = "pwd";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @Test
    void editMessageStatusTest() {
        when(messageStatusDomainService.editMessageStatus(any())).thenReturn(ID);
        when(messageStatusDomainService.getMessageStatus(ID)).thenReturn(getMessageStatusResponse());

        var result =messageStatusService.editMessageStatus(new MessageStatusAddRequest());


        assertEquals(ID, result.getMessageStatusId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(messageStatusDomainService).editMessageStatus(any());
        verify(messageStatusDomainService).editMessageStatus(any());
        verifyNoMoreInteractions(messageStatusDomainService);

    }

    @Test
    void getMessageStatusTest() {
        when(messageStatusDomainService.getMessageStatus(any())).thenReturn(getMessageStatusResponse());

        var result= messageStatusDomainService.getMessageStatus(ID);

        assertEquals(ID, result.getMessageStatusId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());


        verify(messageStatusDomainService).getMessageStatus(any());
        verifyNoMoreInteractions(messageStatusDomainService);
    }

    @Test
    void getAllMessageStatusTest() {
        when(messageStatusDomainService.getAllMessageStatus()).thenReturn(Collections.singletonList(getMessageStatusResponse()));

        var responses= messageStatusDomainService.getAllMessageStatus();

        assertFalse(responses.isEmpty());

        var response = responses.get(0);

        assertEquals(ID, response.getMessageStatusId());
        assertEquals(NAME, response.getName());
        assertEquals(DESCRIPTION, response.getDescription());
        assertEquals(CREATED, response.getCreated());
        assertEquals(MODIFIED, response.getModified());


        verify(messageStatusDomainService).getAllMessageStatus();
        verifyNoMoreInteractions(messageStatusDomainService);
    }

    private MessageStatusResponse getMessageStatusResponse() {
        return new MessageStatusResponse()
                .setMessageStatusId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }
}
