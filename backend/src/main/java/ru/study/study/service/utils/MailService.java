package ru.study.study.service.utils;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import ru.study.study.config.MailSenderFactory;
import ru.study.study.dto.inner.EmailRequest;
import ru.study.study.utils.Pair;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSenderFactory mailSenderFactory;

    @Value("${spring.mail.from}")
    private String from;


    public void sendMail(EmailRequest request) {
        if (!mailValidator(from)) {
            System.out.println("email отправителя введен не корректно! Проверьте");
        }

        if(subjectChecker(request.getSubject())){
            System.out.println("Тема письма не заполнена. Проверьте");
        }

        if(notEmptyDestinationChecker(request.getTo())){
            System.out.println("Отсутствует адрес для отправки. Проверьте");
        }

        if(notEmptyBccChecker(request.getBcc())){
            System.out.println("Отсутствует скрытая копия. Проверьте");
        }

        if (notEmptyСcChecker(request.getCc())){
            System.out.println("Отсутствует вторичный получатель. Проверьте");
        }

        if (DestinationValidator(request.getTo())){
            System.out.println("Почта одного или нескольких получателей введены неправильно. Проверьте");
        }
        for (Pair<String, File> file : request.getFiles()) {
            long fileSizeInMb = file.getR().length() / (1024 * 1024);
            if (fileSizeInMb > 15) {
                System.out.println("Файл " + file.getL() + " превышает максимально допустимый размер (15 МБ). Отправка отменена.");
                return;
            }
        }



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

    public boolean mailValidator(String mailUnderChecking) {
        String mail = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";
        return mailUnderChecking.matches(mail);
    }

    public boolean subjectChecker(String subj){
        return !subj.isEmpty();
    }

    public boolean notEmptyDestinationChecker(List<String> list){
        return list.isEmpty();
    }

    public boolean notEmptyBccChecker(List<String> list){
        return list.isEmpty();
    }
    public boolean notEmptyСcChecker(List<String> list){
        return list.isEmpty();
    }

    public boolean DestinationValidator(List<String> list){
        int notValidDestinationCounter = 0;
        for (String str:list){
            if(!mailValidator(str)){
                notValidDestinationCounter++;
            }
        }
        if (notValidDestinationCounter>0){
            return false;
        }
        return true;
    }
}
