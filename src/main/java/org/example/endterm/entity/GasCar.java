package org.example.endterm.entity;

import jakarta.persistence.Entity;

@Entity
public class GasCar extends Car {

    private Integer fuelTank;

    public Integer getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(Integer fuelTank) {
        this.fuelTank = fuelTank;
    }
}
