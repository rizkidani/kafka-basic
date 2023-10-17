package com.test.billing.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerService {
    private EmailService emailService;
    private Gson gson;

    @Autowired
    public KafkaConsumerService(EmailService emailService, Gson gson){
        this.emailService = emailService;
        this.gson = gson;
    }

    @KafkaListener(topics = "digi-topic", groupId = "digi-group-dani")
    public void kafkaListener(String message){
        System.out.println("Received message: " + message);
    }
}
