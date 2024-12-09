package com.aws.aws_integrations.topicsAndQueues.infra;

import com.aws.aws_integrations.config.AwsConfigProperties;
import com.aws.aws_integrations.topicsAndQueues.application.api.MessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sns.SnsClient;

import java.util.UUID;

@Log4j2
@Component
@RequiredArgsConstructor
public class SnsInfraPublisher implements SnsPublisher {
    private final SnsClient snsClient;
    private final AwsConfigProperties awsSnsProperties;

    @Override
    public void publishMessage(MessageRequest messageRequest) {
        log.debug("[start] SnsInfraPublisher - sendMessage");
        snsClient.publish(request -> request.topicArn(awsSnsProperties.getMessageTopic())
                .message(messageRequest.getMessage())
                .messageGroupId(messageRequest.getMessageGroupId())
                .messageDeduplicationId(UUID.randomUUID().toString()));
        log.debug("[finish] SnsInfraPublisher - sendMessage");
    }
}
