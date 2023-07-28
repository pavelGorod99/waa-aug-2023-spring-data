package com.example.w1d3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Address {

    @Id
    private int id;
    private String street;
    private String zip;
    private String city;
}
