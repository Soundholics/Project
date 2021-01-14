package com.example.ratingapi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Rating {


    @Id
    private String productId;
    private List<RatingCollection> ratingCollectionList = new ArrayList<>();

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public List<RatingCollection> getRatingCollectionList() {
        return ratingCollectionList;
    }

    public void setRatingCollectionList(List<RatingCollection> ratingCollectionList) {
        this.ratingCollectionList = ratingCollectionList;
    }
}
