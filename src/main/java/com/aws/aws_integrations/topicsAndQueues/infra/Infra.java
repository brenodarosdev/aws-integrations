package com.aws.aws_integrations.topicsAndQueues.infra;

import com.aws.aws_integrations.topicsAndQueues.application.api.MessageRequest;

public interface Infra {
    void publishMessage(MessageRequest messageRequest);
}
