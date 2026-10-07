package org.aplana.kafka.consumer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.aplana.service.ReceiveMessageService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {
    private final ReceiveMessageService receiveMessageService;

    @KafkaListener(topics = "${ms.kafka.consumer.topicConsumer}",
            concurrency = "${ms.kafka.consumer.concurrencyCount}",
            containerFactory = "consumerContainerFactory")
    public void listenTopic(ConsumerRecord<String, String> message) {
        receiveMessageService.handleMessage(message);
    }
}
