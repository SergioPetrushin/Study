package ru.study.study.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.messagestatus.MessageStatusAddRequest;
import ru.study.study.dto.request.messagestatus.MessageStatusRequest;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserRequest;
import ru.study.study.dto.response.messagestatus.MessageStatusResponse;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.service.MessageStatusService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление статусами сообщений")
public class MessageStatusController {
    private final MessageStatusService messageStatusService;

    private static final String MESSAGE_STATUS_GET = "/api/v1/message-status/get";
    private static final String MESSAGE_STATUS_EDIT = "/api/v1/message-status/egit";
    private static final String MESSAGE_STATUS_GET_ALL = "/api/v1/message-status/get-all";

    @PostMapping(
            value = MESSAGE_STATUS_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public MessageStatusResponse getMessageStatus(@RequestBody MessageStatusRequest request) {

        return messageStatusService.getMessageStatus(request);
    }

    @PostMapping(
            value = MESSAGE_STATUS_GET_ALL,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public List<MessageStatusResponse> getAllMessageStatus() {

        return messageStatusService.getAllMessageStatus();
    }

    @PostMapping(
            value = MESSAGE_STATUS_EDIT,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public MessageStatusResponse editUser(@RequestBody MessageStatusAddRequest request) {
        return messageStatusService.editMessageStatus(request);
    }
}
