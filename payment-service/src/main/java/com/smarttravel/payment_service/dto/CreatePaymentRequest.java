package com.smarttravel.payment_service.dto;

import jakarta.validation.constraints.NotNull;

public class CreatePaymentRequest {

    @NotNull
    private Long bookingId;

    @NotNull
    private Double amount;

    @NotNull
    private String method;

    public CreatePaymentRequest() {}

    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }
}
