package ru.study.study.mapper.messagestatus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.messagestatus.MessageStatusResponse;
import ru.study.study.entity.message.MessageStatus;
import ru.study.study.mapper.Mapper;
@Service
@RequiredArgsConstructor
public class MessageStatusResponseMapper implements Mapper<MessageStatusResponse, MessageStatus> {

    @Override
    public MessageStatusResponse from(MessageStatus source) {
     return new MessageStatusResponse()
                .setMessageStatusId(source.getId())
                .setName(source.getName())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated())
                .setModified(source.getModified());
    }
}
