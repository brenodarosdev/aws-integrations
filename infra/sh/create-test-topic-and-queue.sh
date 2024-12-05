# Create an SNS topic named 'test-topic'
aws --profile localstack --endpoint-url=http://localhost:4566 sns create-topic --name test-topic

# Create an SQS queue named 'test-queue'
aws --profile localstack --endpoint-url=http://localhost:4566 sqs create-queue --queue-name test-queue

# Subscribe the SQS queue 'test-queue' to the SNS topic 'test-topic'
aws --profile localstack --endpoint-url=http://localhost:4566 sns subscribe --topic-arn arn:aws:sns:us-east-1:000000000000:test-topic --protocol sqs --notification-endpoint arn:aws:sqs:us-east-1:000000000000:test-queue
