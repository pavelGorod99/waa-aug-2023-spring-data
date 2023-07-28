package com.example.w1d3.services.implementation;

import com.example.w1d3.dto.UserDto;
import com.example.w1d3.entities.User;
import com.example.w1d3.repositories.UserRepository;
import com.example.w1d3.services.BasicCrudOperations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends GenericCrudOperationsServiceImpl<User, UserDto> implements BasicCrudOperations<UserDto> {

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
        super(modelMapper, userRepository);
    }

    @Override
    public List<UserDto> getAll() {
        return super.getAll(UserDto.class);
    }

    @Override
    public UserDto getById(int id) {
        return super.getById(id, UserDto.class);
    }

    @Override
    public void create(UserDto objectDto) {
        super.create(objectDto, User.class);
    }

    @Override
    public void update(UserDto objectDto) {
        super.update(objectDto.getId(), objectDto, User.class);
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }
}
