package com.aws.aws_integrations.sns.infra;

import com.aws.aws_integrations.sns.application.api.MessageRequest;

public interface SnsInfra {
    void sendNotification(MessageRequest messageRequest);
}
