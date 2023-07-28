package com.example.w1d3.services.implementation;

import com.example.w1d3.dto.ProductDto;
import com.example.w1d3.dto.ReviewDto;
import com.example.w1d3.entities.Category;
import com.example.w1d3.entities.Product;
import com.example.w1d3.entities.Review;
import com.example.w1d3.repositories.ProductRepository;
import com.example.w1d3.services.BasicCrudOperations;
import com.example.w1d3.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends GenericCrudOperationsServiceImpl<Product, ProductDto> implements BasicCrudOperations<ProductDto>, ProductService {

    private ProductRepository productRepository;
    private ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository) {
        super(modelMapper, productRepository);
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDto> getAll() {
        return super.getAll(ProductDto.class);
    }

    @Override
    public ProductDto getById(int id) {
        return super.getById(id, ProductDto.class);
    }

    @Override
    public void create(ProductDto productDto) {
        super.create(productDto, Product.class);
    }

    @Override
    public void update(ProductDto productDto) {
        super.update(productDto.getId(), productDto, Product.class);
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }

    @Override
    public List<ProductDto> findAllByPriceGreaterThan(int price) {
        List<Product> productList = productRepository.findAllByPriceGreaterThan(price);
        List<ProductDto> productDtoList = convertListToDto(productList, ProductDto.class);
        return productDtoList;
    }

    @Override
    public List<ProductDto> findAllByCategoryAndPriceLessThan(int categoryId, int price) {
        List<Product> productList = productRepository.findAllByCategoryAndPriceLessThan(categoryId, price);
        List<ProductDto> productDtoList = convertListToDto(productList, ProductDto.class);
        return productDtoList;
    }

    @Override
    public List<ProductDto> findAllByNameThatContainsKeyboard() {
        List<Product> productList = productRepository.findAllByNameLike("keyboard");
        List<ProductDto> productDtoList = convertListToDto(productList, ProductDto.class);
        return productDtoList;
    }

    @Override
    public List<ReviewDto> findAllByReviewList() {
        List<Review> reviewList = productRepository.findAllByReviewList();
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        reviewList.forEach(review -> {
            ReviewDto reviewDto = modelMapper.map(review, ReviewDto.class);
            reviewDtoList.add(reviewDto);
        });
        return reviewDtoList;
    }
}
