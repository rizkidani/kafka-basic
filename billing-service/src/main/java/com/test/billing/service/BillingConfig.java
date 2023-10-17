package com.test.billing.service;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BillingConfig {

    @Bean
    public Gson createGson(){
        return new Gson();
    }
}
