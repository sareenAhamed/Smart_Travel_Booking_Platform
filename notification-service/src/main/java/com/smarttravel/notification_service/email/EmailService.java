package com.smarttravel.notification_service.email;


public interface EmailService {
    void sendEmail(String to, String subject, String message) throws Exception;
}

