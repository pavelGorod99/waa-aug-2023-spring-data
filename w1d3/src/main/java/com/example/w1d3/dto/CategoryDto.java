package com.example.w1d3.dto;

import com.example.w1d3.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryDto {

    private int id;
    private String name;

    private List<Product> productList;
}
