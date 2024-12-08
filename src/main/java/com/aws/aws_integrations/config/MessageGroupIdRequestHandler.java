package com.aws.aws_integrations.config;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.services.sns.model.PublishRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class MessageGroupIdRequestHandler extends RequestHandler2 {
    @Override
    public AmazonWebServiceRequest beforeExecution(AmazonWebServiceRequest request) {
        AmazonWebServiceRequest amazonWebServiceRequest = super.beforeExecution(request);
        if (amazonWebServiceRequest instanceof PublishRequest publishRequest) {
            log.debug("[sending] message with value {} to topic {}", publishRequest.getMessage(), publishRequest.getTopicArn());
        }
        return amazonWebServiceRequest;
    }
}