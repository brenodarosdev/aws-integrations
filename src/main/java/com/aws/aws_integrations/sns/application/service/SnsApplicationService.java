package com.aws.aws_integrations.sns.application.service;

import com.aws.aws_integrations.sns.application.api.MessageRequest;
import com.aws.aws_integrations.sns.infra.SnsInfra;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class SnsApplicationService implements SnsService {
    private final SnsInfra snsInfra;

    @Value("${aws.topic.sns-sqs-flow}")
    private String snsSqsFlowTopic;

    @Override
    public void sendNotificationSnsSqsFlow(MessageRequest messageRequest) {
        log.info("[start] SnsApplicationService - sendNotificationSnsSqsFlow");
        snsInfra.sendNotification(messageRequest.getMessageGroupId(), messageRequest.getMessage(), snsSqsFlowTopic);
        log.debug("[finish] SnsApplicationService - sendNotificationSnsSqsFlow");
    }
}
