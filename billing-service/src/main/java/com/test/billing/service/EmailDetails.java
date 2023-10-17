package com.test.billing.service;

import lombok.Data;

@Data
public class EmailDetails {
    private String receiver;
    private String messageBody;
    private String subject;
}
