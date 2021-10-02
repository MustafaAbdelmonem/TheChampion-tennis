package com.digital.factory.service;


import org.springframework.stereotype.Service;

@Service
public interface MailSender {

    void sendEmail(String senderMail);
}
