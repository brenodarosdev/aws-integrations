package com.aws.aws_integrations.topicsAndQueues.infra;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Log4j2
@Component
@RequiredArgsConstructor
public class SNSInfraPublisher implements SNSPublisher {
    @Override
    public void sendMessage(@NonNull String message) {
        log.debug("[start] SNSInfraPublisher - sendMessage");
        log.debug("[finish] SNSInfraPublisher - sendMessage");
    }
}
