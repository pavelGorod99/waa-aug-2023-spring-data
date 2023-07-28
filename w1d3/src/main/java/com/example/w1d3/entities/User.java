package com.example.w1d3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class User {

    @Id
    private int id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @OneToOne
    @JoinColumn(name = "id_address")
    private Address address;

    @OneToMany
    @JoinColumn(name = "id_user")
    private List<Review> reviewList;
}
