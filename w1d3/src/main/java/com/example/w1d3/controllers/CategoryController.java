package com.example.w1d3.controllers;

import com.example.w1d3.dto.CategoryDto;
import com.example.w1d3.services.implementation.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping(path = "/{id}")
    public CategoryDto getById(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody CategoryDto categoryDto) {
        categoryService.create(categoryDto);
    }

    @PutMapping
    public void update(@RequestBody CategoryDto categoryDto) {
        categoryService.update(categoryDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        categoryService.deleteById(id);
    }
}
