package com.aws.aws_integrations.topicsAndQueues.application.service;

import lombok.NonNull;

public interface SNSService {
    void sendMessage(@NonNull String message);
}
