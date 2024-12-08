package com.aws.aws_integrations.topicsAndQueues.infra;

import io.awspring.cloud.sqs.annotation.SqsListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class SqsInfraConsumer {

    @SqsListener("test-queue")
    public void listener(String message) {
        log.debug("[start] SqsInfraConsumer - listener");
        log.info("[received] Message: {}", message);
        log.debug("[finish] SqsInfraConsumer - listener");;
    }
}
