package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.MessageRepository;

@Service
@RequiredArgsConstructor
public class MessageDomainService {
    private final MessageRepository messageRepository;
}
