package org.aplana.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReceiveMessageService {

    @Async("taskExecutor")
    public void handleMessage(ConsumerRecord<String, String> message) {

    }
}
