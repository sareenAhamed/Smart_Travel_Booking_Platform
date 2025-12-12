package com.smarttravel.booking_service.client;


import com.smarttravel.booking_service.dto.HotelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hotel-service", url = "http://localhost:8083")
public interface HotelClient {

    @GetMapping("/api/hotels/{id}")
    HotelResponse getHotelById(@PathVariable Long id);
}

