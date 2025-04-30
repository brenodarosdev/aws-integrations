:: sns-sqs-flow
aws --profile localstack --endpoint-url=http://localhost:4566 sns create-topic --name sns-sqs-flow-topic.fifo --attributes FifoTopic=true
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name sns-sqs-flow-queue-dlq.fifo --attributes FifoQueue=true
aws --endpoint-url=http://localhost:4566 sqs create-queue --queue-name sns-sqs-flow-queue.fifo --attributes "{\"FifoQueue\":\"true\",\"RedrivePolicy\":\"{\\\"deadLetterTargetArn\\\":\\\"arn:aws:sqs:us-east-1:000000000000:sns-sqs-flow-queue-dlq.fifo\\\",\\\"maxReceiveCount\\\":\\\"5\\\"}\",\"VisibilityTimeout\":\"5\"}"
aws --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:sns-sqs-flow-topic.fifo --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:sns-sqs-flow-queue.fifo
