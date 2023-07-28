package com.example.w1d3.controllers;

import com.example.w1d3.dto.UserDto;
import com.example.w1d3.services.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @GetMapping(path = "/{id}")
    public UserDto getById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody UserDto userDto) {
        userService.create(userDto);
    }

    @PutMapping
    public void update(@RequestBody UserDto userDto) {
        userService.update(userDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }
}
