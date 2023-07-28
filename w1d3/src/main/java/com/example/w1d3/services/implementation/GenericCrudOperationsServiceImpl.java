package com.example.w1d3.services.implementation;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericCrudOperationsServiceImpl<T, D> {

    private ModelMapper modelMapper;
    private JpaRepository jpaRepository;

    public GenericCrudOperationsServiceImpl(ModelMapper modelMapper, JpaRepository jpaRepository) {
        this.modelMapper = modelMapper;
        this.jpaRepository = jpaRepository;
    }

    protected List<D> convertListToDto(List<T> list, Class<D> clazz) {
        List<D> dtoList = new ArrayList<>();
        list.forEach(object -> {
            D dtoObject = modelMapper.map(object, clazz);
            dtoList.add(dtoObject);
        });
        return dtoList;
    }

    protected List<D> getAll(Class<D> clazz) {
        List<T> list = jpaRepository.findAll();
        List<D> dtoList = convertListToDto(list, clazz);
        return dtoList;
    }

    private T getObjectById(int id) {
        Optional<T> object = jpaRepository.findById(id);
        if (object.isPresent()) {
            return object.get();
        }
        return null;
    }

    protected D getById(int id, Class<D> clazz) {
        T object = getObjectById(id);
        D objectDto = modelMapper.map(object, clazz);
        return objectDto;
    }

    protected void create(D objectDto, Class<T> clazz) {
        T object = modelMapper.map(objectDto, clazz);
        jpaRepository.save(object);
    }

    protected void update(int id, D objectDto, Class<T> clazz) {
        T object = getObjectById(id);
        if (object != null) {
            object = modelMapper.map(objectDto, clazz);
            jpaRepository.save(object);
        }
    }

    protected void deleteById(int id) {
        jpaRepository.deleteById(id);
    }
}
