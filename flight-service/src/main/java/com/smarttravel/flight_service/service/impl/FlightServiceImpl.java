package com.smarttravel.flight_service.service.impl;


import com.smarttravel.flight_service.dto.CreateFlightRequest;
import com.smarttravel.flight_service.dto.FlightResponse;
import com.smarttravel.flight_service.entity.Flight;
import com.smarttravel.flight_service.exception.ResourceNotFoundException;
import com.smarttravel.flight_service.repository.FlightRepository;
import com.smarttravel.flight_service.service.FlightService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    private FlightResponse toResponse(Flight flight) {
        FlightResponse r = new FlightResponse();
        r.setId(flight.getId());
        r.setAirline(flight.getAirline());
        r.setSource(flight.getSource());
        r.setDestination(flight.getDestination());
        r.setDate(flight.getDate());
        r.setPrice(flight.getPrice());
        r.setSeatsAvailable(flight.getSeatsAvailable());
        return r;
    }

    @Override
    public FlightResponse addFlight(CreateFlightRequest request) {
        Flight flight = new Flight();
        flight.setAirline(request.getAirline());
        flight.setSource(request.getSource());
        flight.setDestination(request.getDestination());
        flight.setDate(request.getDate());
        flight.setPrice(request.getPrice());
        flight.setSeatsAvailable(request.getSeatsAvailable());

        Flight saved = flightRepository.save(flight);
        return toResponse(saved);
    }

    @Override
    public FlightResponse getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found: " + id));
        return toResponse(flight);
    }

    @Override
    public List<FlightResponse> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<FlightResponse> searchFlights(String source, String destination, LocalDate date) {
        return flightRepository.findBySourceAndDestinationAndDate(source, destination, date)
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
