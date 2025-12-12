package com.smarttravel.notification_service.service;


import com.smarttravel.notification_service.dto.SendNotificationRequest;
import com.smarttravel.notification_service.dto.NotificationResponse;

public interface NotificationService {
    NotificationResponse sendNotification(SendNotificationRequest request);
}

