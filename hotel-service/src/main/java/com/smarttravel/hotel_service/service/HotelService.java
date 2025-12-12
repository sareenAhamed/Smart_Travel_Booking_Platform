package com.smarttravel.hotel_service.service;


import com.smarttravel.hotel_service.dto.CreateHotelRequest;
import com.smarttravel.hotel_service.dto.HotelResponse;

import java.util.List;

public interface HotelService {

    HotelResponse addHotel(CreateHotelRequest request);

    HotelResponse getHotelById(Long id);

    List<HotelResponse> getAllHotels();

    List<HotelResponse> getHotelsByCity(String city);
}

