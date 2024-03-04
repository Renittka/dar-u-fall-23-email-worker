package kz.dar.university.email.worker.service.kafka;

import jakarta.mail.MessagingException;
import kz.dar.university.email.worker.domain.TaskDetailed;
import kz.dar.university.email.worker.service.mail.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReceiverService {

    private final MailService mailService;

    @KafkaListener(
            topics = "${spring.kafka.task.topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeMessages(TaskDetailed task) throws MessagingException {
        log.info("Received Message: " + task);
        mailService.sendEmail(task);
    }

}
