package com.lcwd.Rating.service;

import com.lcwd.Rating.entities.Rating;

import java.util.List;

public interface RatingServices {

    //create
    Rating create(Rating rating);

    //getAll Rating

    List<Rating> getAllRating();

    //get all hotel rating by HotelId

    List<Rating> getAllHotelRating(String hotelId);

    //get all userRating by userId

    List<Rating> getAllUserRating(String userId);
}
