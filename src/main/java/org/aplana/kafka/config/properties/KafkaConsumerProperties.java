package org.aplana.kafka.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("ms.kafka.consumer")
public class KafkaConsumerProperties {
    private String clientId;
    private String groupId;
    private String bootstrapServer;
}
