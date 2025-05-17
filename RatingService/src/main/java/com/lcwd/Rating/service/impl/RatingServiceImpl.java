package com.lcwd.Rating.service.impl;

import com.lcwd.Rating.entities.Rating;
import com.lcwd.Rating.repository.RatingRepository;
import com.lcwd.Rating.service.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingServices {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating create(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllHotelRating(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public List<Rating> getAllUserRating(String userId) {
        return ratingRepository.findByUserId(userId);
    }
}
