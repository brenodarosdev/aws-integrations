package com.aws.aws_integrations.topicsAndQueues.application.api;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerTest {

    @SqsListener("test-queue")
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
