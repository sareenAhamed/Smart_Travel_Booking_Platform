package com.smarttravel.booking_service.service.impl;


import com.smarttravel.booking_service.client.FlightClient;
import com.smarttravel.booking_service.client.HotelClient;
import com.smarttravel.booking_service.client.UserClient;
import com.smarttravel.booking_service.dto.*;
import com.smarttravel.booking_service.entity.Booking;
import com.smarttravel.booking_service.exception.ResourceNotFoundException;
import com.smarttravel.booking_service.repository.BookingRepository;
import com.smarttravel.booking_service.service.BookingService;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserClient userClient;
    private final FlightClient flightClient;
    private final HotelClient hotelClient;

    public BookingServiceImpl(
            BookingRepository bookingRepository,
            UserClient userClient,
            FlightClient flightClient,
            HotelClient hotelClient
    ) {
        this.bookingRepository = bookingRepository;
        this.userClient = userClient;
        this.flightClient = flightClient;
        this.hotelClient = hotelClient;
    }

    @Override
    public BookingResponse createBooking(CreateBookingRequest request) {

        // Call USER service
        UserResponse user = userClient.getUserById(request.getUserId());
        if (user == null)
            throw new ResourceNotFoundException("User not found");

        // Call FLIGHT service
        FlightResponse flight = flightClient.getFlightById(request.getFlightId());
        if (flight == null)
            throw new ResourceNotFoundException("Flight not found");

        // Call HOTEL service
        HotelResponse hotel = hotelClient.getHotelById(request.getHotelId());
        if (hotel == null)
            throw new ResourceNotFoundException("Hotel not found");

        // Save booking
        Booking booking = new Booking();
        booking.setUserId(request.getUserId());
        booking.setFlightId(request.getFlightId());
        booking.setHotelId(request.getHotelId());

        Booking saved = bookingRepository.save(booking);

        // Convert to response
        BookingResponse response = new BookingResponse();
        response.setId(saved.getId());
        response.setUserId(saved.getUserId());
        response.setFlightId(saved.getFlightId());
        response.setHotelId(saved.getHotelId());
        response.setBookedAt(saved.getBookedAt());

        return response;
    }

    @Override
    public BookingResponse getBooking(Long id) {
        Booking b = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));

        BookingResponse r = new BookingResponse();
        r.setId(b.getId());
        r.setUserId(b.getUserId());
        r.setFlightId(b.getFlightId());
        r.setHotelId(b.getHotelId());
        r.setBookedAt(b.getBookedAt());

        return r;
    }
}

