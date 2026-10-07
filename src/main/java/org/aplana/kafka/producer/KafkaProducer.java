package org.aplana.kafka.producer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(@NonNull ProducerRecord<String, String> producerRecord) {
        kafkaTemplate.send(producerRecord)
                .addCallback(
                        success -> {},
                        ex -> {}
                );
    }
}
