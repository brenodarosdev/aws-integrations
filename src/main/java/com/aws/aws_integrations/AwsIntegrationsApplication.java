package com.aws.aws_integrations;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsIntegrationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsIntegrationsApplication.class, args);
	}

	@SqsListener("test-queue")
	public void listen(String message) {
		System.out.println(message);
	}
}
