package com.example.w1d3.services;

import java.util.List;

public interface BasicCrudOperations<D> {
    List<D> getAll();
    D getById(int id);
    void create(D objectDto);
    void update(D objectDto);
    void deleteById(int id);
}
