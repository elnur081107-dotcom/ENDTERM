package org.example.endterm.patterns;

import org.example.endterm.entity.Car;
import org.example.endterm.entity.Rental;

import java.time.LocalDate;

public class RentalBuilder {

    private Car car;
    private int customerId;
    private LocalDate start;
    private LocalDate end;

    public RentalBuilder car(Car car) {
        this.car = car;
        return this;
    }

    public RentalBuilder customer(int customerId) {
        this.customerId = customerId;
        return this;
    }

    public RentalBuilder start(LocalDate start) {
        this.start = start;
        return this;
    }

    public RentalBuilder end(LocalDate end) {
        this.end = end;
        return this;
    }

    public Rental build() {
        return new Rental(car, customerId, start, end);
    }
}

