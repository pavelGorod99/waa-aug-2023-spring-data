package com.example.w1d3.services;

import com.example.w1d3.dto.ProductDto;
import com.example.w1d3.dto.ReviewDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllByPriceGreaterThan(int price);
    List<ProductDto> findAllByCategoryAndPriceLessThan(int categoryId, int price);
    List<ProductDto> findAllByNameThatContainsKeyboard();
    List<ReviewDto> findAllByReviewList();
}
