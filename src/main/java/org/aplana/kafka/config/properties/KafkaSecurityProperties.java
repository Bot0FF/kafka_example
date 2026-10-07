package org.aplana.kafka.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("ms.kafka.ssl")
public class KafkaSecurityProperties {
    private Boolean isEnableSsl;
    private String protocol;
    private Resource keyStoreLocation;
    private String keyStorePassword;
    private String keyStoreType;
    private Resource trustStoreLocation;
    private String trustStorePassword;
    private String trustStoreType;
    private String keyPassword;
}
