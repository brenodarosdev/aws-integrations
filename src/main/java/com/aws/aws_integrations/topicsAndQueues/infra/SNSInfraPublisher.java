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
public class SNSInfraPublisher implements SNSPublisher {
    private final NotificationMessagingTemplate snsMessagePublisher;
    private final AwsConfigProperties awsSnsProperties;


    @Override
    public void sendMessage(@NonNull String message) {
        log.debug("[start] SNSInfraPublisher - sendMessage");
        if (snsMessagePublisher.getDefaultDestination() == null) {
            snsMessagePublisher.setDefaultDestinationName(awsSnsProperties.getMessageTopic());
        }
        snsMessagePublisher.sendNotification(awsSnsProperties.getMessageTopic(), message);
        log.debug("[finish] SNSInfraPublisher - sendMessage");
    }
}
