package com.books.NotificationService.Service;


import com.books.NotificationService.Domain.Notification;

public interface NotificationService {
    Notification createNotification(Notification notification);
}