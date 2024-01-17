package ru.study.study.mapper.messagestatus;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.messagestatus.MessageStatusAddRequest;
import ru.study.study.entity.message.MessageStatus;
import ru.study.study.mapper.Merger;
@Service
@RequiredArgsConstructor
public class MessageStatusMerger implements Merger<MessageStatus, MessageStatusAddRequest> {
    @Override
    public MessageStatus merge(MessageStatus target, MessageStatusAddRequest source) {
        return target.setName(source.getName())
                .setDescription(source.getDescription());
    }
}
