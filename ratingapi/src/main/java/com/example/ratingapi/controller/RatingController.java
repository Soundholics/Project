package com.example.ratingapi.controller;


import com.example.ratingapi.entity.RatingCollection;
import com.example.ratingapi.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/ratings")
public class RatingController {


    @Autowired
    RatingService ratingService;

    @GetMapping
    String getCalled()
    {
        return "working";
    }


    @GetMapping(value = ("/get/{id}"))
    List<RatingCollection> getRatingById(@PathVariable("id") String id)
    {
        return ratingService.getRating(id);
    }

    @PostMapping(value ="/save/{id}")
    String setRatingById(@PathVariable("id") String id,@RequestBody RatingCollection ratingCollection)
    {
        return ratingService.setRating(id,ratingCollection);
    }



}
