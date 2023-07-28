package com.example.w1d3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "product")
public class Product {

    @Id
    private int id;
    private String name;
    private int price;
    private float rating;

    @ManyToOne
    private Category category;

    @OneToMany
    @JoinColumn(name = "id_product")
    private List<Review> reviewList;
}
