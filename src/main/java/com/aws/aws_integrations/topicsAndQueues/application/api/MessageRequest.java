package com.aws.aws_integrations.topicsAndQueues.application.api;

import lombok.Value;

@Value
public class MessageRequest {
    String message;
    String messageGroupId;
}
