package com.lcwd.Rating.controllers;

import com.lcwd.Rating.entities.Rating;
import com.lcwd.Rating.service.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
   private RatingServices ratingServices;

    @PreAuthorize("hasAuthority ('Admin')")
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.create(rating));

    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating()
    {
        return  ResponseEntity.ok(ratingServices.getAllRating());
    }

    @PreAuthorize("hasAuthority ('SCOPE_internal') || hasAuthority ('Admin')")
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getAllHotelRating(@PathVariable String hotelId)
    {
        return  ResponseEntity.ok(ratingServices.getAllHotelRating(hotelId));
    }


    @PreAuthorize("hasAuthority ('SCOPE_internal') || hasAuthority ('Admin')")
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getAllUserRating(@PathVariable String userId)
    {
        return  ResponseEntity.ok(ratingServices.getAllUserRating(userId));
    }




}
