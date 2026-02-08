package org.example.endterm.controller;

import org.example.endterm.dto.CarRequestDto;
import org.example.endterm.entity.Car;
import org.example.endterm.service.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public Car create(@RequestBody CarRequestDto dto) {
        return carService.create(dto);
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable Long id) {
        return carService.getById(id);
    }

    @PutMapping("/{id}")
    public Car update(@PathVariable Long id,
                      @RequestBody CarRequestDto dto) {
        return carService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        carService.delete(id);
    }
}
