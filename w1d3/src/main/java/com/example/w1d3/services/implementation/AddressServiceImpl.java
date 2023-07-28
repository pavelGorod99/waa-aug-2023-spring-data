package com.example.w1d3.services.implementation;

import com.example.w1d3.dto.AddressDto;
import com.example.w1d3.entities.Address;
import com.example.w1d3.repositories.AddressRepository;
import com.example.w1d3.services.AddressService;
import com.example.w1d3.services.BasicCrudOperations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl extends GenericCrudOperationsServiceImpl<Address, AddressDto> implements BasicCrudOperations<AddressDto> {

//    private ModelMapper modelMapper;
//    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(ModelMapper modelMapper, AddressRepository addressRepository) {
        super(modelMapper, addressRepository);
//        this.modelMapper = modelMapper;
//        this.addressRepository = addressRepository;
    }

    @Override
    public List<AddressDto> getAll() {
        return super.getAll(AddressDto.class);
    }

    @Override
    public AddressDto getById(int id) {
        return super.getById(id, AddressDto.class);
    }

    @Override
    public void create(AddressDto addressDto) {
        super.create(addressDto, Address.class);
    }

    @Override
    public void update(AddressDto addressDto) {
        super.update(addressDto.getId(), addressDto, Address.class);
    }

    @Override
    public void deleteById(int id) {
        super.deleteById(id);
    }
}
