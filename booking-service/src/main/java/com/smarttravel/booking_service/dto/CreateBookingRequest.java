package com.smarttravel.booking_service.dto;


import jakarta.validation.constraints.NotNull;

public class CreateBookingRequest {

    @NotNull
    private Long userId;

    @NotNull
    private Long flightId;

    @NotNull
    private Long hotelId;

    public CreateBookingRequest() {}

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getFlightId() { return flightId; }
    public void setFlightId(Long flightId) { this.flightId = flightId; }

    public Long getHotelId() { return hotelId; }
    public void setHotelId(Long hotelId) { this.hotelId = hotelId; }
}

