package com.aws.aws_integrations.sns.application.service;

import com.aws.aws_integrations.sns.application.api.MessageRequest;
import com.aws.aws_integrations.sns.infra.SnsInfra;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.management.MBeanServerDelegate;

@Log4j2
@Service
@RequiredArgsConstructor
public class SnsApplicationService implements SnsService {
    private final SnsInfra snsInfra;

    @Override
    public void sendNotificationSnsSqsFlow(MessageRequest messageRequest) {
        log.info("[start] SnsApplicationService - sendNotificationSnsSqsFlow");
        snsInfra.sendNotification(messageRequest);
        log.debug("[finish] SnsApplicationService - sendNotificationSnsSqsFlow");
    }
}
