package com.smarttravel.flight_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateFlightRequest {

    @NotBlank
    private String airline;

    @NotBlank
    private String source;

    @NotBlank
    private String destination;

    @NotNull
    private LocalDate date;

    @NotNull
    private Double price;

    @NotNull
    private Integer seatsAvailable;

    public CreateFlightRequest() {}

    // Getters & Setters
    public String getAirline() { return airline; }
    public void setAirline(String airline) { this.airline = airline; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getSeatsAvailable() { return seatsAvailable; }
    public void setSeatsAvailable(Integer seatsAvailable) { this.seatsAvailable = seatsAvailable; }
}

