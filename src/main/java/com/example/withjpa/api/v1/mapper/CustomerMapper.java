package com.example.withjpa.api.v1.mapper;

import com.example.withjpa.api.v1.model.CustomerDTO;
import com.example.withjpa.domain.Customer;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer Customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}