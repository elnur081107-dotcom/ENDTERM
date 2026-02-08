package org.example.endterm.entity;

import org.example.endterm.patterns.CarFactory;

public class CarBuilder {

    private final Car car;

    public CarBuilder(String type) {
        this.car = CarFactory.createCar(type);
    }

    public CarBuilder name(String name) {
        car.setName(name);
        return this;
    }

    public CarBuilder pricePerDay(double price) {
        car.setPricePerDay(price);
        return this;
    }

    public CarBuilder available(boolean available) {
        car.setAvailable(available);
        return this;
    }

    public CarBuilder batteryCapacity(Integer capacity) {
        if (car instanceof ElectricCar electricCar) {
            electricCar.setBatteryCapacity(capacity);
        }
        return this;
    }

    public CarBuilder fuelTank(Integer tank) {
        if (car instanceof GasCar gasCar) {
            gasCar.setFuelTank(tank);
        }
        return this;
    }

    public Car build() {
        return car;
    }
}
