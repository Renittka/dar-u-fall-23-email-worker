package kz.dar.university.email.worker.service.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import kz.dar.university.email.worker.domain.EmployeeDTO;
import kz.dar.university.email.worker.domain.TaskDetailed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Map;

import static kz.dar.university.email.worker.util.Util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(TaskDetailed task) {
        EmployeeDTO employee = task.getEmployee();
        String text = String.format(
                "Title: %s,%nStatus: %s",
                task.getTitle(),
                task.getStatus()
        );

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(EMAIL_FROM);
        message.setTo(employee.getEmail());
        message.setSubject(NEW_TASK_TITLE);
        message.setText(text);
        emailSender.send(message);

        log.info("Email message: " + message);
        log.info("Finished");
    }

    @Override
    public void sendEmail(TaskDetailed task) throws MailException, MessagingException {
        EmployeeDTO employee = task.getEmployee();
        String text = String.format(
                "Title: %s,%nStatus: %s",
                task.getTitle(),
                task.getStatus()
        );

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(employee.getEmail());
        helper.setText(text);

        for (Map.Entry<String, String> file : task.getFiles().entrySet()) {
            byte[] doc = Base64.getDecoder().decode(file.getValue());
            helper.addAttachment(file.getKey(), new ByteArrayResource(doc));
        }

        helper.setSubject(NEW_TASK_TITLE);
        emailSender.send(message);
    }

}
