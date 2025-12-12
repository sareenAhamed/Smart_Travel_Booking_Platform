package com.smarttravel.flight_service.controller;


import com.smarttravel.flight_service.dto.CreateFlightRequest;
import com.smarttravel.flight_service.dto.FlightResponse;
import com.smarttravel.flight_service.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping
    public ResponseEntity<FlightResponse> addFlight(@Valid @RequestBody CreateFlightRequest request) {
        return ResponseEntity.ok(flightService.addFlight(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getFlightById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @GetMapping
    public ResponseEntity<?> searchFlights(
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String destination,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate date) {

        // If search params missing → return all
        if (source == null || destination == null || date == null) {
            return ResponseEntity.ok(flightService.getAllFlights());
        }

        return ResponseEntity.ok(flightService.searchFlights(source, destination, date));
    }
}

