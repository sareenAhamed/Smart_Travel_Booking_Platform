package com.smarttravel.payment_service.service.impl;


import com.smarttravel.payment_service.dto.CreatePaymentRequest;
import com.smarttravel.payment_service.dto.PaymentResponse;
import com.smarttravel.payment_service.entity.Payment;
import com.smarttravel.payment_service.exception.ResourceNotFoundException;
import com.smarttravel.payment_service.repository.PaymentRepository;
import com.smarttravel.payment_service.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    private PaymentResponse toResponse(Payment p) {
        PaymentResponse r = new PaymentResponse();
        r.setId(p.getId());
        r.setBookingId(p.getBookingId());
        r.setAmount(p.getAmount());
        r.setMethod(p.getMethod());
        r.setStatus(p.getStatus());
        r.setPaidAt(p.getPaidAt());
        return r;
    }

    @Override
    public PaymentResponse makePayment(CreatePaymentRequest request) {

        Payment payment = new Payment();
        payment.setBookingId(request.getBookingId());
        payment.setAmount(request.getAmount());
        payment.setMethod(request.getMethod());

        // Simple rule — mark all payments as SUCCESS
        payment.setStatus("SUCCESS");

        Payment saved = paymentRepository.save(payment);
        return toResponse(saved);
    }

    @Override
    public PaymentResponse getPayment(Long id) {
        Payment p = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        return toResponse(p);
    }
}
