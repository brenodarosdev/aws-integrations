package com.aws.aws_integrations.topicsAndQueues.application.service;

import com.aws.aws_integrations.topicsAndQueues.application.api.MessageRequest;

public interface Service {
    void sendMessage(MessageRequest messageRequest);
}
