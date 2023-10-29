package ru.study.study.service.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.repository.MessageStatusRepository;

@Service
@RequiredArgsConstructor
public class MessageStatusDomainService {
    private final MessageStatusRepository messageStatusRepository;
}
