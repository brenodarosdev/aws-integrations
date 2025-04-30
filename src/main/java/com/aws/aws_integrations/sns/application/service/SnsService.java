package com.aws.aws_integrations.sns.application.service;

import com.aws.aws_integrations.sns.application.api.MessageRequest;

public interface SnsService {
    void sendNotificationSnsSqsFlow(MessageRequest messageRequest);
}
