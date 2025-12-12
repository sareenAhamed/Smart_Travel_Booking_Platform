package com.smarttravel.notification_service.controller;


import com.smarttravel.notification_service.dto.SendNotificationRequest;
import com.smarttravel.notification_service.dto.NotificationResponse;
import com.smarttravel.notification_service.service.NotificationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NotificationResponse> send(@Valid @RequestBody SendNotificationRequest req) {
        return ResponseEntity.ok(service.sendNotification(req));
    }
}

