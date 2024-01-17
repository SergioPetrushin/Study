package ru.study.study.mapper.messagestatus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.messagestatus.MessageStatusAddRequest;
import ru.study.study.entity.message.MessageStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageStatusMergerTest {
    @InjectMocks
    private MessageStatusMerger messageStatusMerger;

    private final static Long ID = 1L;
    private final static String NAME = "NAME";
    private final static String DESCRIPTION = "DESCRIPTION";

    @Test
    void mergeTest() {
        var source = spy(getMessageStatusAddRequest());

        var result = messageStatusMerger.merge(new MessageStatus(ID), source);

        assertEquals(ID, result.getId());
        assertEquals(NAME, result.getName());
        assertEquals(DESCRIPTION, result.getDescription());

       // verify(source).getMessageStatusId(); - Это нужно?
        verify(source).getName();
        verify(source).getDescription();
        verifyNoMoreInteractions(source);
    }


        private MessageStatusAddRequest getMessageStatusAddRequest(){
        return new MessageStatusAddRequest()
                .setMessageStatusId(ID)
                .setName(NAME)
                .setDescription(DESCRIPTION);
    }
}
