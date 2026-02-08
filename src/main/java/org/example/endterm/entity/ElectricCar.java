package org.example.endterm.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ELECTRIC")
public class ElectricCar extends Car {

    private Integer batteryCapacity;

    @Override
    public void update(String name, Double pricePerDay, Integer batteryCapacity) {
        super.update(name, pricePerDay, batteryCapacity);

        if (batteryCapacity != null) {
            this.batteryCapacity = batteryCapacity;
        }
    }

    public Integer getBatteryCapacity() {
        return batteryCapacity;
    }

    protected void setBatteryCapacity(Integer batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }
}


