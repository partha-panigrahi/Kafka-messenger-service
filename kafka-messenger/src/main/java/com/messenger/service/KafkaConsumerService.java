package com.messenger.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private String latestMessage;

    @KafkaListener(
            topics = "partha-topic",
            groupId = "console-consumer-36347"
    )
    public void consumeMessage(String message) {

        System.out.println("Message received: " + message);

        latestMessage = message;
    }

    public String getLatestMessage() {
        return latestMessage;
    }
}