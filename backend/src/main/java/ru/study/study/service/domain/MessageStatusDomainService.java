package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.messagestatus.MessageStatusAddRequest;
import ru.study.study.dto.response.messagestatus.MessageStatusResponse;
import ru.study.study.entity.message.MessageStatus;
import ru.study.study.mapper.messagestatus.MessageStatusMerger;
import ru.study.study.mapper.messagestatus.MessageStatusResponseMapper;
import ru.study.study.repository.MessageStatusRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageStatusDomainService {
    private final MessageStatusRepository repository;
    private final MessageStatusResponseMapper messageStatusResponseMapper;
    private final MessageStatusMerger messageStatusMerger;

    @Transactional
    public MessageStatusResponse getMessageStatus(Long messageId) {
        MessageStatus source = repository.getReferenceById(messageId);

        return messageStatusResponseMapper.from(source);
    }
    @Transactional
    public List<MessageStatusResponse> getAllMessageStatus() {
        return messageStatusResponseMapper.from(repository.findAll());
    }

    @Transactional
    public Long editMessageStatus(MessageStatusAddRequest request){
        var status = repository.getReferenceById(request.getMessageStatusId());
return repository.save(messageStatusMerger.merge(status, request)).getId();
    }
}
