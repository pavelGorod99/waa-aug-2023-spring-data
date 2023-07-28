package com.example.w1d3.dto;

import com.example.w1d3.entities.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductDto {

    private int id;
    private String name;
    private int price;
    private float rating;

    private List<Review> reviewList;
}
