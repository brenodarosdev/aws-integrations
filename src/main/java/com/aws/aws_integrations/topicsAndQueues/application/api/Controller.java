package com.aws.aws_integrations.topicsAndQueues.application.api;

import com.aws.aws_integrations.topicsAndQueues.application.service.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class Controller {
    private final Service service;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        log.debug("[start] SnsApi - sendMessage");
        service.sendMessage(messageRequest);
        log.debug("[finish] SnsApi - sendMessage");
    }
}
