package com.aws.aws_integrations.topicsAndQueues.infra;

import lombok.NonNull;

public interface SnsPublisher {
    void publishMessage(@NonNull String message);
}
