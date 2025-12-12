package com.smarttravel.hotel_service.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateHotelRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String city;

    @NotNull
    private Double pricePerNight;

    @NotNull
    private Integer availableRooms;

    @NotNull
    private LocalDate availableFrom;

    @NotNull
    private LocalDate availableTo;

    @NotNull
    private Double rating;

    public CreateHotelRequest() {}

    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public Double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(Double pricePerNight) { this.pricePerNight = pricePerNight; }

    public Integer getAvailableRooms() { return availableRooms; }
    public void setAvailableRooms(Integer availableRooms) { this.availableRooms = availableRooms; }

    public LocalDate getAvailableFrom() { return availableFrom; }
    public void setAvailableFrom(LocalDate availableFrom) { this.availableFrom = availableFrom; }

    public LocalDate getAvailableTo() { return availableTo; }
    public void setAvailableTo(LocalDate availableTo) { this.availableTo = availableTo; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
}

