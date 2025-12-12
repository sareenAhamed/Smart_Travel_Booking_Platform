package com.smarttravel.hotel_service.controller;


import com.smarttravel.hotel_service.dto.CreateHotelRequest;
import com.smarttravel.hotel_service.dto.HotelResponse;
import com.smarttravel.hotel_service.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) { this.hotelService = hotelService; }

    @PostMapping
    public ResponseEntity<HotelResponse> addHotel(@Valid @RequestBody CreateHotelRequest request) {
        return ResponseEntity.ok(hotelService.addHotel(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelResponse> getHotel(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @GetMapping
    public ResponseEntity<?> searchHotels(@RequestParam(required = false) String city) {

        if (city != null) {
            return ResponseEntity.ok(hotelService.getHotelsByCity(city));
        }

        return ResponseEntity.ok(hotelService.getAllHotels());
    }
}

