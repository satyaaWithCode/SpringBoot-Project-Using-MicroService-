package com.lcwd.Rating.repository;

import com.lcwd.Rating.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String>
{
    //custom method creation
    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
