package com.books.NotificationService.Service;


import com.books.NotificationService.Repository.NotificationRepository;
import com.books.NotificationService.Domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public Notification createNotification(Notification notification) {
        emailService.sendEmail(notification);
        return notificationRepository.save(notification);
    }
}
