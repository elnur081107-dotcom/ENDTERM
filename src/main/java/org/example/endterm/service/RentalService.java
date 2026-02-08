package org.example.endterm.service;

import org.example.endterm.dto.RentalRequestDto;
import org.example.endterm.entity.Car;
import org.example.endterm.entity.Rental;
import org.example.endterm.patterns.RentalBuilder;
import org.example.endterm.repository.CarRepository;
import org.example.endterm.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final CarRepository carRepository;
    private final RentalRepository rentalRepository;

    public RentalService(CarRepository carRepository,
                         RentalRepository rentalRepository) {
        this.carRepository = carRepository;
        this.rentalRepository = rentalRepository;
    }

    public void rent(RentalRequestDto dto) {

        Car car = carRepository.findById(dto.carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        if (!car.isAvailable()) {
            throw new RuntimeException("Car not available");
        }

        car.rent();
        carRepository.save(car);

        rentalRepository.save(
                new RentalBuilder()
                        .car(car)
                        .customer(dto.customerId)
                        .start(dto.startDate)
                        .end(dto.endDate)
                        .build()
        );
    }

    public List<Rental> getAll() {
        return rentalRepository.findAll();
    }

    public Rental getById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not found"));
    }


}

