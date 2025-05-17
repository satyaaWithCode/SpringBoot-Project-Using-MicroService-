package com.lcwd.hotel.service;

import com.lcwd.hotel.entities.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAll();

    //singleGetValue

    Hotel getOne(String id);
}
