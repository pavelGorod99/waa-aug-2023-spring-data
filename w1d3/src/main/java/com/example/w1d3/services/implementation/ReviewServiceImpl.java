package com.example.w1d3.services.implementation;

import com.example.w1d3.dto.ReviewDto;
import com.example.w1d3.entities.Review;
import com.example.w1d3.repositories.ReviewRepository;
import com.example.w1d3.services.BasicCrudOperations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl extends GenericCrudOperationsServiceImpl<Review, ReviewDto> implements BasicCrudOperations<ReviewDto> {

    @Autowired
    public ReviewServiceImpl(ModelMapper modelMapper, ReviewRepository reviewRepository) {
        super(modelMapper, reviewRepository);
    }

    @Override
    public List<ReviewDto> getAll() {
        return super.getAll(ReviewDto.class);
    }

    @Override
    public ReviewDto getById(int id) {
        return super.getById(id, ReviewDto.class);
    }

    @Override
    public void create(ReviewDto objectDto) {
        super.create(objectDto, Review.class);
    }

    @Override
    public void update(ReviewDto objectDto) {
        super.update(objectDto.getId(), objectDto, Review.class);
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }
}
