package org.example.endterm.service;

import org.example.endterm.dto.CarRequestDto;
import org.example.endterm.entity.Car;
import org.example.endterm.entity.CarBuilder;
import org.example.endterm.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(CarRequestDto dto) {

        CarBuilder builder = new CarBuilder(dto.type)
                .name(dto.name)
                .pricePerDay(dto.pricePerDay)
                .available(true);

        if (dto.batteryCapacity != null) {
            builder.batteryCapacity(dto.batteryCapacity);
        }

        Car car = builder.build();
        return carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    public Car update(Long id, CarRequestDto dto) {
        Car car = getById(id);

        car.update(
                dto.name,
                dto.pricePerDay,
                dto.batteryCapacity
        );

        return carRepository.save(car);
    }

    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found");
        }
        carRepository.deleteById(id);
    }
}
