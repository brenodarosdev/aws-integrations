package com.aws.aws_integrations.topicsAndQueues.application.service;

import com.aws.aws_integrations.topicsAndQueues.application.api.MessageRequest;
import com.aws.aws_integrations.topicsAndQueues.infra.Infra;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ApplicationService implements Service {
    private final Infra infra;

    @Override
    public void sendMessage(MessageRequest messageRequest) {
        log.debug("[start] SnsApplicationService - sendMessage");
        infra.publishMessage(messageRequest);
        log.debug("[finish] SnsApplicationService - sendMessage");
    }
}
