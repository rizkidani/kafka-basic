package com.test.billing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private JavaMailSender javaMailSender;
    private String sender = "billing@digicourse.id";

    @Autowired
    public EmailService (JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public boolean sendEmail(EmailDetails emailDetails){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDetails.getReceiver());
            simpleMailMessage.setSubject(emailDetails.getSubject());
            simpleMailMessage.setText(emailDetails.getMessageBody());
            javaMailSender.send(simpleMailMessage);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
