package com.smarttravel.flight_service.service;


import com.smarttravel.flight_service.dto.CreateFlightRequest;
import com.smarttravel.flight_service.dto.FlightResponse;

import java.time.LocalDate;
import java.util.List;

public interface FlightService {

    FlightResponse addFlight(CreateFlightRequest request);

    FlightResponse getFlightById(Long id);

    List<FlightResponse> getAllFlights();

    List<FlightResponse> searchFlights(String source, String destination, LocalDate date);
}
