//package ru.study.study.service.utils;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.test.util.ReflectionTestUtils;
//import ru.study.study.config.MailSenderFactory;
//import ru.study.study.dto.inner.EmailRequest;
//import ru.study.study.exception.MessageSendException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.mockito.Mockito.spy;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class MailServiceTest {
//
//
//    @Mock
//    private MailSenderFactory mailSenderFactory;
//
//    @InjectMocks
//    private MailService service;
//
//
//    @BeforeEach
//    void init() {
//        ReflectionTestUtils.setField(service, "from", "test@test.ru");
//        ReflectionTestUtils.setField(service, "sendMail", true);
//    }
//
//    @Test
//    void sendMailTest1() {
//
//        var destinations = new ArrayList<String>();
//        destinations.add("vyushin1403@yandex.ru");
//
//        var mailSender = spy(new JavaMailSenderImpl());
//
//        when(mailSenderFactory.getJavaMailSender()).thenReturn(mailSender);
//
//        var request = getEmailRequest(destinations);
//
//      assertThatThrownBy(() ->
//            service.sendMail(request))
//                .isInstanceOf(MessageSendException.class)
//                .hasMessage("Произошла ошибка при отправке почты: Mail server connection failed. Failed messages: com.sun.mail.util.MailConnectException: Couldn't connect to host, port: localhost, 25; timeout -1;\n" +
//                        "  nested exception is:\n" +
//                        "\tjava.net.ConnectException: В соединении отказано");
//
//
//    }
//
//
//    private EmailRequest getEmailRequest(List<String> destinations) {
//        return new EmailRequest()
//                .setTo(destinations)
//                .setCc(new ArrayList<>())
//                .setBcc(new ArrayList<>())
//                .setSubject("123")
//                .setText("");
//
//    }
//}
