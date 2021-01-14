package com.example.ratingapi.service;

import com.example.ratingapi.entity.RatingCollection;

import java.util.List;

public interface RatingService {

    String setRating(String productId, RatingCollection ratingCollection);
    List<RatingCollection> getRating(String productId);
}
