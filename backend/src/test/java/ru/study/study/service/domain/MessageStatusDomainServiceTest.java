package ru.study.study.service.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.messagestatus.MessageStatusAddRequest;
import ru.study.study.dto.response.messagestatus.MessageStatusResponse;
import ru.study.study.entity.message.MessageStatus;
import ru.study.study.mapper.messagestatus.MessageStatusMerger;
import ru.study.study.mapper.messagestatus.MessageStatusResponseMapper;
import ru.study.study.repository.MessageStatusRepository;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageStatusDomainServiceTest {
    @Mock
    private MessageStatusRepository repository;
    @Mock
    private MessageStatusResponseMapper messageStatusResponseMapper;
    @Mock
    private MessageStatusMerger messageStatusMerger;

    @InjectMocks
    private MessageStatusDomainService service;

    private static final Long ID = 1L;
    private static final String LOGIN = "login";
    private static final String PWD = "pwd";
    private static final String NAME = "name";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);

    @Test
    void getMessageStatusTest() {
        when(messageStatusResponseMapper.from((MessageStatus) any())).thenReturn(getMessageStatusResponse());
        when(repository.getReferenceById(any())).thenReturn(getMessageStatus());

        var result = service.getMessageStatus(ID);

        assertEquals(ID, result.getMessageStatusId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());
        assertEquals(CREATED, result.getCreated());
        assertEquals(MODIFIED, result.getModified());

        verify(messageStatusResponseMapper).from((MessageStatus) any());
        verify(repository).getReferenceById(any());
        verifyNoMoreInteractions(repository, messageStatusResponseMapper, messageStatusMerger);
    }

    @Test
    void getAllMessageStatusTest() {
        when(messageStatusResponseMapper.from((List<MessageStatus>) any())).thenReturn(List.of(getMessageStatusResponse(),
                getMessageStatusResponse(), getMessageStatusResponse()));
        when(repository.findAll()).thenReturn(List.of(getMessageStatus(),
                getMessageStatus(), getMessageStatus()));

        var results = service.getAllMessageStatus();

        for (var result : results) {
            assertEquals(ID, result.getMessageStatusId());
            assertEquals(NAME, result.getName());
            assertEquals(DESCRIPTION, result.getDescription());
            assertEquals(CREATED, result.getCreated());
            assertEquals(MODIFIED, result.getModified());
        }

        verify(repository).findAll();
        verify(messageStatusResponseMapper).from((List<MessageStatus>) any());

        verifyNoMoreInteractions(repository, messageStatusResponseMapper, messageStatusMerger);
    }

    @Test
    void editMessageStatus() {
        when(repository.getReferenceById(any())).thenReturn(getMessageStatus());

        when(messageStatusMerger.merge(any(), any())).thenReturn(getMessageStatus());
        when(repository.save(any())).thenReturn(getMessageStatus());
        service.editMessageStatus(new MessageStatusAddRequest());

        verify(repository).getReferenceById(any());
        verify(repository).save(any());
        verify(messageStatusMerger).merge(any(), any());
        verifyNoMoreInteractions(repository, messageStatusResponseMapper, messageStatusMerger);

    }

    private MessageStatusResponse getMessageStatusResponse() {
        return new MessageStatusResponse()
                .setMessageStatusId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

    private MessageStatus getMessageStatus() {
        return new MessageStatus()
                .setId(ID)
                .setCreated(CREATED)
                .setModified(MODIFIED)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }

}
