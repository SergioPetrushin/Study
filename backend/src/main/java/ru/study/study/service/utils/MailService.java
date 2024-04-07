package ru.study.study.service.utils;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.study.study.config.MailSenderFactory;
import ru.study.study.dto.inner.EmailRequest;
import ru.study.study.exception.MessageSendException;
import ru.study.study.utils.Pair;

import java.io.File;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSenderFactory mailSenderFactory;

    @Value("${spring.mail.from}")
    private String from;

    @Value("${spring.mail.max-file-size}")
    private int maxFileSize;

    @Value("${spring.mail.send-mail}")
    private boolean sendMail;

    public void sendMail(EmailRequest request) {

        if (!sendMail) System.out.println("Отправка почты выключена. Письмо не отправлено!");

        subjectChecker(request.getSubject());
        destinationValidator(request);
        filesValidator(request);

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
            throw new MessageSendException("Произошла ошибка при отправке почты: " + ex.getMessage());
        }
    }

    private boolean mailValidator(String mailUnderChecking) {
        String mailReg = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";
        return !mailUnderChecking.matches(mailReg);
    }

    private void subjectChecker(String subj) {
        if (subj == null || subj.isEmpty()) throw new MessageSendException("Тема письма не заполнена. Проверьте");
    }

    private void destinationValidator(EmailRequest emailRequest) {

        var invalidEmails = new ArrayList<>();


        emailRequest.getTo().forEach(email -> {
            if (mailValidator(email)) invalidEmails.add(email);
        });

        emailRequest.getCc().forEach(email -> {
            if (mailValidator(email)) invalidEmails.add(email);
        });

        emailRequest.getBcc().forEach(email -> {
            if (mailValidator(email)) invalidEmails.add(email);
        });

        emailRequest.getTo().removeIf(invalidEmails::contains);
        emailRequest.getCc().removeIf(invalidEmails::contains);
        emailRequest.getBcc().removeIf(invalidEmails::contains);

       if (!invalidEmails.isEmpty()) { System.out.println("Некорректные почтовые адреса: " + invalidEmails);}

        if (emailRequest.getTo().isEmpty() && emailRequest.getCc().isEmpty() && emailRequest.getBcc().isEmpty())
            throw new MessageSendException("Для отправки письма должен быть указан хотя бы один корректный почтовый адрес!");

    }

    private void filesValidator(EmailRequest request) {

        for (Pair<String, File> file : request.getFiles()) {
            long fileSizeInMb = file.getR().length() / (1024 * 1024);
            if (fileSizeInMb > maxFileSize) {
             throw new MessageSendException(
                String.format("Файл %s превышает максимально допустимый размер (%s МБ). Отправка отменена.",
                        file.getL(),
                        maxFileSize));
            }
        }
    }
}
