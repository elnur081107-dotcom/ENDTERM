package org.example.endterm.service;

import org.example.endterm.dto.CustomerRequestDto;
import org.example.endterm.entity.Customer;
import org.example.endterm.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer create(CustomerRequestDto dto) {
        return repository.save(new Customer(dto.name, dto.email));
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }
}

