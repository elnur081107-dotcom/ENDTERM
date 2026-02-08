package org.example.endterm.controller;

import org.example.endterm.dto.RentalRequestDto;
import org.example.endterm.entity.Rental;
import org.example.endterm.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @PostMapping
    public void rent(@RequestBody RentalRequestDto dto) {
        service.rent(dto);
    }
@GetMapping
public List<Rental> getAll() {
    return service.getAll();}

@GetMapping("/{id}")
public Rental getById(@PathVariable Long id) {
    return service.getById(id);}
}




