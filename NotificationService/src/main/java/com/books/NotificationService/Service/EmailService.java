package com.books.NotificationService.Service;

import com.books.NotificationService.Domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendEmail(Notification notification) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("niitproject45@outlook.com");
            message.setReplyTo("niitproject45@outlook.com");
            message.setTo(notification.getRecipient());
            message.setSubject("Notification: " + notification.getSubject());
            message.setText("Hello,\n\n" + notification.getMessage());

            emailSender.send(message);
        }catch(Exception ex){

        }
    }
}
