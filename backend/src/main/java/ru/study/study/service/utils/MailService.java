package ru.study.study.service.utils;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.study.study.config.MailSenderFactory;
import ru.study.study.dto.inner.EmailRequest;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSenderFactory mailSenderFactory;

    @Value("${spring.mail.from}")
    private String from;


    public void sendMail(EmailRequest request) {

        try {
            var sender = mailSenderFactory.getJavaMailSender();

            var msg = sender.createMimeMessage();

            var message = new MimeMessageHelper(msg, true, "UTF-8");


            message.setFrom(from);
            message.setSubject(request.getSubject());
            message.setText(request.getText());

            message.setTo(request.getTo().toArray(new String[0]));
            message.setCc(request.getCc().toArray(new String[0]));
            message.setBcc(request.getBcc().toArray(new String[0]));


            request.getFiles().forEach(file -> {

                try {
                    message.addAttachment(file.getL(), file.getR());
                } catch (MessagingException ignored) {
                }
            });


            sender.send(msg);
        } catch (Exception ex) {
            throw new RuntimeException("Произошла ошибка при отправке почты: " + ex.getMessage());
        }


    }


}
