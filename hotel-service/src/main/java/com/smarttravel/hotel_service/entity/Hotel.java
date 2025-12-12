package com.smarttravel.hotel_service.entity;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "hotels", indexes = {
        @Index(name = "idx_city", columnList = "city")
})
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String city;

    private Double pricePerNight;

    private Integer availableRooms;

    private LocalDate availableFrom;

    private LocalDate availableTo;

    private Double rating;

    public Hotel() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

