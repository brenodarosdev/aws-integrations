package com.aws.aws_integrations.topicsAndQueues.infra;

import lombok.NonNull;

public interface SNSPublisher {
    void sendMessage(@NonNull String message);
}
