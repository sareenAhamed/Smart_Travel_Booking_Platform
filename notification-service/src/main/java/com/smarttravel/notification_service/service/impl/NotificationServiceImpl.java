package com.smarttravel.notification_service.service.impl;

import com.smarttravel.notification_service.dto.SendNotificationRequest;
import com.smarttravel.notification_service.dto.NotificationResponse;
import com.smarttravel.notification_service.email.EmailService;
import com.smarttravel.notification_service.entity.Notification;
import com.smarttravel.notification_service.repository.NotificationRepository;
import com.smarttravel.notification_service.service.NotificationService;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    public NotificationServiceImpl(NotificationRepository notificationRepository,
                                   EmailService emailService) {
        this.notificationRepository = notificationRepository;
        this.emailService = emailService;
    }

    @Override
    public NotificationResponse sendNotification(SendNotificationRequest req) {

        Notification n = new Notification();
        n.setUserId(req.getUserId());
        n.setEmail(req.getEmail());
        n.setMessage(req.getMessage());

        try {
            emailService.sendEmail(req.getEmail(),
                    "SmartTravel Notification",
                    req.getMessage());

            n.setStatus("SENT");

        } catch (Exception e) {
            n.setStatus("FAILED");
        }

        Notification saved = notificationRepository.save(n);

        NotificationResponse resp = new NotificationResponse();
        resp.setId(saved.getId());
        resp.setUserId(saved.getUserId());
        resp.setEmail(saved.getEmail());
        resp.setMessage(saved.getMessage());
        resp.setStatus(saved.getStatus());
        resp.setSentAt(saved.getSentAt());

        return resp;
    }
}

