package com.aws.aws_integrations.sns.infra;

import com.aws.aws_integrations.sns.application.api.MessageRequest;

public interface SnsInfra {
    <T> void sendNotification(String groupId, T payload, String topic);
}
