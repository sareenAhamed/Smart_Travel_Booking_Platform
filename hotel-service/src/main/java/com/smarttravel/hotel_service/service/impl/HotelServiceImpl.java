package com.smarttravel.hotel_service.service.impl;


import com.smarttravel.hotel_service.dto.CreateHotelRequest;
import com.smarttravel.hotel_service.dto.HotelResponse;
import com.smarttravel.hotel_service.entity.Hotel;
import com.smarttravel.hotel_service.exception.ResourceNotFoundException;
import com.smarttravel.hotel_service.repository.HotelRepository;
import com.smarttravel.hotel_service.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    private HotelResponse toResponse(Hotel h) {
        HotelResponse r = new HotelResponse();
        r.setId(h.getId());
        r.setName(h.getName());
        r.setCity(h.getCity());
        r.setPricePerNight(h.getPricePerNight());
        r.setAvailableRooms(h.getAvailableRooms());
        r.setAvailableFrom(h.getAvailableFrom());
        r.setAvailableTo(h.getAvailableTo());
        r.setRating(h.getRating());
        return r;
    }

    @Override
    public HotelResponse addHotel(CreateHotelRequest request) {
        Hotel h = new Hotel();
        h.setName(request.getName());
        h.setCity(request.getCity());
        h.setPricePerNight(request.getPricePerNight());
        h.setAvailableRooms(request.getAvailableRooms());
        h.setAvailableFrom(request.getAvailableFrom());
        h.setAvailableTo(request.getAvailableTo());
        h.setRating(request.getRating());

        return toResponse(hotelRepository.save(h));
    }

    @Override
    public HotelResponse getHotelById(Long id) {
        Hotel h = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel not found: " + id));
        return toResponse(h);
    }

    @Override
    public List<HotelResponse> getAllHotels() {
        return hotelRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<HotelResponse> getHotelsByCity(String city) {
        return hotelRepository.findByCity(city).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}

