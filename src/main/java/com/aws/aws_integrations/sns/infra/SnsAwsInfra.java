package com.aws.aws_integrations.sns.infra;

import com.aws.aws_integrations.sns.application.api.MessageRequest;
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
    public void sendNotification(MessageRequest messageRequest) {
        log.info("[start] SnsAwsInfra - sendNotification");
        SnsNotification<MessageRequest> notification = SnsNotification.builder(messageRequest)
                .deduplicationId(UUID.randomUUID().toString())
                .groupId(messageRequest.getMessageGroupId())
                .build();
        snsOperations.sendNotification("test-topic.fifo", notification);
        log.debug("[sent] Notification with value \"{}\" to topic \"{}\"", messageRequest.toString(), "test-topic.fifo");
        log.debug("[finish] SnsAwsInfra - sendNotification");
    }
}
