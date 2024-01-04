package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.messagestatus.MessageStatusAddRequest;
import ru.study.study.dto.request.messagestatus.MessageStatusRequest;
import ru.study.study.dto.response.messagestatus.MessageStatusResponse;
import ru.study.study.service.domain.MessageStatusDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageStatusService {
    private final MessageStatusDomainService messageStatusDomainService;

    public MessageStatusResponse editMessageStatus(MessageStatusAddRequest request){
        var id = messageStatusDomainService.editMessageStatus(request);
        return messageStatusDomainService.getMessageStatus(id);
    }

    public MessageStatusResponse getMessageStatus(MessageStatusRequest request){
        return messageStatusDomainService.getMessageStatus(request.getMessageStatusId());
    }

    public List<MessageStatusResponse> getAllMessageStatus(){
        return messageStatusDomainService.getAllMessageStatus();
    }
}
