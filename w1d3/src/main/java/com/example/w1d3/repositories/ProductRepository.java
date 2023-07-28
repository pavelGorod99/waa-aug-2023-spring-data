package com.example.w1d3.repositories;

import com.example.w1d3.entities.Category;
import com.example.w1d3.entities.Product;
import com.example.w1d3.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAllByPriceGreaterThan(int price);
    List<Product> findAllByCategoryAndPriceLessThan(int categoryId, int price);
    List<Product> findAllByNameLike(String substring);
    List<Review> findAllByReviewList();
}
