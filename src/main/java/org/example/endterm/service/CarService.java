package org.example.endterm.service;

import org.example.endterm.dto.CarRequestDto;
import org.example.endterm.entity.Car;
import org.example.endterm.entity.CarBuilder;
import org.example.endterm.repository.CarRepository;
import org.example.endterm.utils.CarCache;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarCache cache = CarCache.getInstance();

    private static final String ALL_CARS_KEY = "allCars";

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
        Car saved = carRepository.save(car);

        cache.remove(ALL_CARS_KEY);

        return saved;
    }

    public List<Car> getAll() {

        if (cache.contains(ALL_CARS_KEY)) {
            System.out.println("Returning cars from cache...");
            return (List<Car>) cache.get(ALL_CARS_KEY);
        }

        System.out.println("Fetching cars from database...");
        List<Car> cars = carRepository.findAll();

        cache.put(ALL_CARS_KEY, cars);

        return cars;
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

        Car updated = carRepository.save(car);

        cache.remove(ALL_CARS_KEY);

        return updated;
    }

    public void delete(Long id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car not found");
        }

        carRepository.deleteById(id);

        cache.remove(ALL_CARS_KEY);
    }
}
