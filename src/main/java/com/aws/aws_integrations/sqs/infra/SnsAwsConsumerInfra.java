package com.aws.aws_integrations.sqs.infra;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SnsAwsConsumerInfra {
    @SqsListener("${aws.queue.sns-sqs-flow}")
    public void listener(String message) {
        log.info("[start] SnsAwsConsumerInfra - listener");
        log.debug("[received] Message: {}", message);
        log.debug("[finish] SnsAwsConsumerInfra - listener");
    }
}
