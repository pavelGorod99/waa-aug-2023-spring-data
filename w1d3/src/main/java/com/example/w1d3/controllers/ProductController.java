package com.example.w1d3.controllers;

import com.example.w1d3.dto.ProductDto;
import com.example.w1d3.dto.ReviewDto;
import com.example.w1d3.services.implementation.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ProductDto getById(@PathVariable int id) {
        return productService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ProductDto productDto) {
        productService.create(productDto);
    }

    @PutMapping
    public void update(@RequestBody ProductDto productDto) {
        productService.update(productDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        productService.deleteById(id);
    }

    @GetMapping(path = "/by-price-greater-than")
    public List<ProductDto> findAllByPriceGreaterThan(@RequestParam int price) {
        return productService.findAllByPriceGreaterThan(price);
    }

    @GetMapping(path = "/by-category-and-price-less-than")
    public List<ProductDto> findAllByCategoryAndPriceLessThan(@RequestParam int categoryId, @RequestParam int price) {
        return productService.findAllByCategoryAndPriceLessThan(categoryId, price);
    }

    @GetMapping(path = "/by-name-that-contains-keyboard")
    public List<ProductDto> findAllByNameThatContainsKeyboard() {
        return productService.findAllByNameThatContainsKeyboard();
    }

    @GetMapping(path = "/by-name-that-contains-keyboard")
    public List<ReviewDto> findAllByReviewList() {
        return productService.findAllByReviewList();
    }
}
