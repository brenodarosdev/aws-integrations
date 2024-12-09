package com.aws.aws_integrations.topicsAndQueues.infra;

import com.aws.aws_integrations.topicsAndQueues.application.api.MessageRequest;

public interface SnsPublisher {
    void publishMessage(MessageRequest messageRequest);
}
