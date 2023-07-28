package com.example.w1d3.controllers;

import com.example.w1d3.dto.ReviewDto;
import com.example.w1d3.services.implementation.ReviewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/reviews")
public class ReviewController {

    private ReviewServiceImpl reviewService;

    @Autowired
    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDto> getAll() {
        return reviewService.getAll();
    }

    @GetMapping(path = "/{id}")
    public ReviewDto getById(@PathVariable int id) {
        return reviewService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody ReviewDto reviewDto) {
        reviewService.create(reviewDto);
    }

    @PutMapping
    public void update(@RequestBody ReviewDto reviewDto) {
        reviewService.update(reviewDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        reviewService.deleteById(id);
    }
}
