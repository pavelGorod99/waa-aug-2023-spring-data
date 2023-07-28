package com.example.w1d3.services.implementation;

import com.example.w1d3.dto.CategoryDto;
import com.example.w1d3.entities.Category;
import com.example.w1d3.repositories.CategoryRepository;
import com.example.w1d3.services.BasicCrudOperations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends GenericCrudOperationsServiceImpl<Category, CategoryDto> implements BasicCrudOperations<CategoryDto> {

    @Autowired
    public CategoryServiceImpl(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        super(modelMapper, categoryRepository);
    }

    @Override
    public List<CategoryDto> getAll() {
        return super.getAll(CategoryDto.class);
    }

    @Override
    public CategoryDto getById(int id) {
        return super.getById(id, CategoryDto.class);
    }

    @Override
    public void create(CategoryDto categoryDto) {
        super.create(categoryDto, Category.class);
    }

    @Override
    public void update(CategoryDto categoryDto) {
        super.update(categoryDto.getId(), categoryDto, Category.class);
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }
}
