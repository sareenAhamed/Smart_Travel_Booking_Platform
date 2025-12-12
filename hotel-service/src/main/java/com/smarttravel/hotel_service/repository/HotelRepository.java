package com.smarttravel.hotel_service.repository;


import com.smarttravel.hotel_service.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByCity(String city);

}

