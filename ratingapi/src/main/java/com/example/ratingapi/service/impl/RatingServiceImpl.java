package com.example.ratingapi.service.impl;

import com.example.ratingapi.entity.Rating;
import com.example.ratingapi.entity.RatingCollection;
import com.example.ratingapi.repository.RatingRepository;
import com.example.ratingapi.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {


    @Autowired
    RatingRepository ratingRepository;

    @Override
    public String setRating(String productId, RatingCollection ratingCollection) {

        try {

            Rating rating = ratingRepository.findById(productId).get();
            List<RatingCollection> ratingCollectionList = rating.getRatingCollectionList();
            ratingCollectionList.add(ratingCollection);
            rating.setRatingCollectionList(ratingCollectionList);
            ratingRepository.save(rating);

            return "saved";

        }catch (Exception exp)
        {
            System.out.println(exp.getMessage());
           try {
               Rating rating = new Rating();
               List<RatingCollection> ratingCollectionList = new ArrayList<>();
               RatingCollection ratingCollection1 = new RatingCollection();
               ratingCollection1.setRating(ratingCollection.getRating());
               ratingCollection1.setCustomerId(ratingCollection.getCustomerId());
               ratingCollection1.setReview(ratingCollection.getReview());

               ratingCollectionList.add(ratingCollection1);
               rating.setProductId(productId);

               rating.setRatingCollectionList(ratingCollectionList);
               ratingRepository.save(rating);
               return  "stored";

           }catch (Exception ex1)
           {
               System.out.println(ex1.getMessage());
               return  "eroor";
           }
//             return "error";
        }


    }

    @Override
    public List<RatingCollection> getRating(String productId) {
        return ratingRepository.findById(productId).get().getRatingCollectionList();
    }
}
