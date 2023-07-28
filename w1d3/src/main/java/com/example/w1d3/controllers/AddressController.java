package com.example.w1d3.controllers;

import com.example.w1d3.dto.AddressDto;
import com.example.w1d3.services.implementation.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/addresses")
public class AddressController {

    private AddressServiceImpl addressService;

    @Autowired
    public AddressController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.getAll();
    }

    @GetMapping(path = "/{id}")
    public AddressDto getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody AddressDto addressDto) {
        addressService.create(addressDto);
    }

    @PutMapping
    public void update(@RequestBody AddressDto addressDto) {
        addressService.update(addressDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable int id) {
        addressService.deleteById(id);
    }
}
