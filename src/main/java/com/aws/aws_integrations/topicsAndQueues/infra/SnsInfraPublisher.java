package com.aws.aws_integrations.topicsAndQueues.infra;

import com.aws.aws_integrations.config.AwsConfigProperties;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class SnsInfraPublisher implements SnsPublisher {
    private final NotificationMessagingTemplate snsMessagePublisher;
    private final AwsConfigProperties awsSnsProperties;


    @Override
    public void publishMessage(@NonNull String message) {
        log.debug("[start] SnsInfraPublisher - sendMessage");
        snsMessagePublisher.sendNotification(awsSnsProperties.getMessageTopic(), message);
        log.debug("[finish] SnsInfraPublisher - sendMessage");
    }
}
