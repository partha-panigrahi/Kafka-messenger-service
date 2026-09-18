package com.messenger.controller;

import com.messenger.service.KafkaConsumerService;
import com.messenger.service.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaConsumerService kafkaConsumerService;
    private final KafkaProducerService producerService;

    public KafkaController(KafkaConsumerService kafkaConsumerService, KafkaProducerService producerService) {
        this.kafkaConsumerService = kafkaConsumerService;
        this.producerService=producerService;
    }

    @GetMapping("/message")
    public String getMessage() {

        return kafkaConsumerService.getLatestMessage();
    }

    @PostMapping("/send-message")
    public String sendMessage(@RequestBody String message) {

        producerService.sendMessage(message);

        return "Message sent successfully";
    }
}
