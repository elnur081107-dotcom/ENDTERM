package org.example.endterm.controller;

import org.example.endterm.dto.CustomerRequestDto;
import org.example.endterm.entity.Customer;
import org.example.endterm.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public Customer create(@RequestBody CustomerRequestDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAll();
    }
}

