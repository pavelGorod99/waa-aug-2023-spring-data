package com.example.w1d3.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "category")
public class Category {

    @Id
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "id_category")
    private List<Product> productList;
}
