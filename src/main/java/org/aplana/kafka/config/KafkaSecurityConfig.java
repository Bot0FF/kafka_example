package org.aplana.kafka.config;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.config.SslConfigs;
import org.aplana.kafka.config.properties.KafkaSecurityProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class KafkaSecurityConfig {
    private final KafkaSecurityProperties kafkaSecurityProperties;

    protected void sslProperties(Map<String, Object> properties) {
        if(kafkaSecurityProperties.getIsEnableSsl()) {
            properties.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, kafkaSecurityProperties.getProtocol());
            setSecurityProperties(properties);
        }
    }

    @SneakyThrows
    private void setSecurityProperties(Map<String, Object> properties) {
        setProperties(properties, SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, kafkaSecurityProperties.getTrustStoreLocation().getFile().getAbsolutePath());
        setProperties(properties, SslConfigs.SSL_TRUSTSTORE_PASSWORD_CONFIG, kafkaSecurityProperties.getTrustStorePassword());
        setProperties(properties, SslConfigs.SSL_TRUSTSTORE_TYPE_CONFIG, kafkaSecurityProperties.getTrustStoreType());
        setProperties(properties, SslConfigs.SSL_KEYSTORE_LOCATION_CONFIG, kafkaSecurityProperties.getKeyStoreLocation().getFile().getAbsolutePath());
        setProperties(properties, SslConfigs.SSL_KEYSTORE_PASSWORD_CONFIG, kafkaSecurityProperties.getKeyStorePassword());
        setProperties(properties, SslConfigs.SSL_KEYSTORE_TYPE_CONFIG, kafkaSecurityProperties.getKeyStoreType());
        setProperties(properties, SslConfigs.SSL_KEY_PASSWORD_CONFIG, kafkaSecurityProperties.getKeyPassword());
    }

    private void setProperties(Map<String, Object> properties, String key, String value) {
        if(isNotBlank(value)) {
            properties.put(key, value);
        }
    }

    private boolean isNotBlank(String value) {
        return null != value && value.length() > 0;
    }
}
