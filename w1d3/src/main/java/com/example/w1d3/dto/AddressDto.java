package com.example.w1d3.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDto {

    private int id;
    private String street;
    private String zip;
    private String city;
}
