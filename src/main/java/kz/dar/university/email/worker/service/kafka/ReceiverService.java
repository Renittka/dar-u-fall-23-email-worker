package kz.dar.university.email.worker.service.kafka;

import kz.dar.university.email.worker.domain.Greeting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiverService {

    @KafkaListener(
            topics = "${spring.kafka.task.topic}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumeMessages(Greeting message) {
        log.info("Received Message: " + message);
    }

}
