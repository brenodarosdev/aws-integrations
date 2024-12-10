package com.aws.aws_integrations.topicsAndQueues.infra;

import com.aws.aws_integrations.topicsAndQueues.application.api.MessageRequest;
import io.awspring.cloud.sns.core.SnsNotification;
import io.awspring.cloud.sns.core.SnsOperations;
import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class AwsInfra implements Infra {
    private final SnsOperations snsOperations;

    @Override
    public void publishMessage(MessageRequest messageRequest) {
        log.debug("[start] SnsInfraPublisher - sendMessage");
        SnsNotification<MessageRequest> notification = SnsNotification.builder(messageRequest)
                .deduplicationId(UUID.randomUUID().toString())
                .groupId(messageRequest.getMessageGroupId())
                .build();
        snsOperations.sendNotification("test-topic.fifo", notification);
        log.debug("[finish] SnsInfraPublisher - sendMessage");
    }

    @SqsListener("test-queue.fifo")
    public void listener(String message) {
        log.debug("[start] SqsInfraConsumer - listener");
        log.info("[received] Message: {}", message);
        log.debug("[finish] SqsInfraConsumer - listener");;
    }
}
