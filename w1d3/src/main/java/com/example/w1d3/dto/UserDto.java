package com.example.w1d3.dto;

import com.example.w1d3.entities.Address;
import com.example.w1d3.entities.Review;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserDto {

    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    private Address address;

    private List<Review> reviewList;
}
