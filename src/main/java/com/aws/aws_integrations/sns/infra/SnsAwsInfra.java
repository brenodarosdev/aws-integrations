package com.aws.aws_integrations.sns.infra;

import io.awspring.cloud.sns.core.SnsNotification;
import io.awspring.cloud.sns.core.SnsOperations;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class SnsAwsInfra implements SnsInfra {
    private final SnsOperations snsOperations;

    @Override
    public <T> void sendNotification(String groupId, T payload, String topic) {
        log.info("[start] SnsAwsInfra - sendNotification");
        SnsNotification<T> notification = SnsNotification.builder(payload)
                .deduplicationId(UUID.randomUUID().toString())
                .groupId(groupId)
                .build();
        snsOperations.sendNotification(topic, notification);
        log.debug("[sent] Notification with value \"{}\" to topic \"{}\"", payload.toString(), topic);
        log.debug("[finish] SnsAwsInfra - sendNotification");
    }
}
