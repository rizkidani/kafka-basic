package com.test.user.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private KafkaProducerService kafkaProducerService;
    private Gson gson;
    public UserService(KafkaProducerService kafkaProducerService, Gson gson){
        this.kafkaProducerService = kafkaProducerService;
        this.gson = gson;
    }
    public void requestBill(String userId){
        String emailByUserId = "rizkidanisetiadi@gmail.com";

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setEmail(emailByUserId);

        kafkaProducerService.sendMessage(gson.toJson(userDto));
    }
}
