package com.sdkexercises.internship2025.handlers;

import org.springframework.stereotype.Component;
import software.amazon.awssdk.services.sqs.model.Message;

import static io.awspring.cloud.sqs.annotation.SqsListenerAcknowledgementMode.ON_SUCCESS;

@Component
public class SqsListener {

    @io.awspring.cloud.sqs.annotation.SqsListener(
            value = "queueName.fifo",
            acknowledgementMode = ON_SUCCESS,
            maxConcurrentMessages = "10"
    )
    public void onMessage(Message message) {
        System.out.println("Received Sqs message body: " + message.body());
    }
}
