package com.aws.aws_integrations.topicsAndQueues.application.api;

import com.aws.aws_integrations.topicsAndQueues.application.service.SNSService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class SNSAPI {
    private final SNSService snsService;

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody @NonNull String message) {
        log.debug("[start] SNSAPI - sendMessage");
        snsService.sendMessage(message);
        log.debug("[finish] SNSAPI - sendMessage");
    }
}
