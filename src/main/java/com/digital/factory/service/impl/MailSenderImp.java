package com.digital.factory.service.impl;

import com.digital.factory.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderImp implements MailSender {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String senderMail) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(senderMail);

        msg.setSubject("Congratulation");
        msg.setText("Congratulation ");

        javaMailSender.send(msg);

    }
}
