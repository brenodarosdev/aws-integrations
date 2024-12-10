package com.aws.aws_integrations.topicsAndQueues.application.api;

import lombok.Value;

@Value
public class MessageRequest {
    String message;
    String messageGroupId;

    public MessageRequest(String message, String messageGroupId) {
        this.message = message;
        this.messageGroupId = messageGroupId;
    }
}
