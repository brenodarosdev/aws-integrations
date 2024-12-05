package com.aws.aws_integrations.topicsAndQueues.application.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class SNSApplicationService implements SNSService {
    @Override
    public void sendMessage(@NonNull String message) {
        log.debug("[start] SNSApplicationService - sendMessage");
        log.debug("[finish] SNSApplicationService - sendMessage");
    }
}
