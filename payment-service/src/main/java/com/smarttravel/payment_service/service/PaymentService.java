package com.smarttravel.payment_service.service;

import com.smarttravel.payment_service.dto.CreatePaymentRequest;
import com.smarttravel.payment_service.dto.PaymentResponse;

public interface PaymentService {
    PaymentResponse makePayment(CreatePaymentRequest request);
    PaymentResponse getPayment(Long id);
}


