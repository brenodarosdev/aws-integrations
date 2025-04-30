package com.aws.aws_integrations.sns.application.api;

import com.aws.aws_integrations.sns.application.service.SnsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/sns/v1")
@RequiredArgsConstructor
public class SnsController {
    private final SnsService snsService;

    @PostMapping("/sns-to-sqs")
    public void postNotificationSnsSqsFlow(@RequestBody MessageRequest messageRequest) {
        log.info("[start] SnsController - postNotificationFlowSnsSqs");
        snsService.sendNotificationSnsSqsFlow(messageRequest);
        log.debug("[finish] SnsController - postNotificationFlowSnsSqs");
    }
}
