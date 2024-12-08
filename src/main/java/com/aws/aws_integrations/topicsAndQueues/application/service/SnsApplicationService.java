package com.aws.aws_integrations.topicsAndQueues.application.service;

import com.aws.aws_integrations.topicsAndQueues.infra.SnsPublisher;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class SnsApplicationService implements SnsService {
    private final SnsPublisher snsPublisher;

    @Override
    public void sendMessage(@NonNull String message) {
        log.debug("[start] SnsApplicationService - sendMessage");
        snsPublisher.publishMessage(message);
        log.debug("[finish] SnsApplicationService - sendMessage");
    }
}
