package com.smarttravel.flight_service.repository;


import com.smarttravel.flight_service.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findBySourceAndDestinationAndDate(String source, String destination, LocalDate date);

}

