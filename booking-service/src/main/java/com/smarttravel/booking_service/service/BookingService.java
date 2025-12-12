package com.smarttravel.booking_service.service;


import com.smarttravel.booking_service.dto.BookingResponse;
import com.smarttravel.booking_service.dto.CreateBookingRequest;

public interface BookingService {

    BookingResponse createBooking(CreateBookingRequest request);

    BookingResponse getBooking(Long id);
}

