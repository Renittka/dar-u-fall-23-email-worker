package kz.dar.university.email.worker.service.mail;

import jakarta.mail.MessagingException;
import kz.dar.university.email.worker.domain.TaskDetailed;

public interface MailService {

    void sendSimpleMessage(TaskDetailed task);

    void sendEmail(TaskDetailed task) throws MessagingException;

}
