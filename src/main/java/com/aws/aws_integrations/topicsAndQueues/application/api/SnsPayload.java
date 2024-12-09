package com.aws.aws_integrations.topicsAndQueues.application.api;

public class SnsPayload {
    private String message;

    public SnsPayload(String message) {
        this.message = message;
    }
}
