package org.example.endterm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "car_type")
public abstract class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;

    protected double pricePerDay;

    protected boolean available;


    public void update(String name, Double pricePerDay, Integer batteryCapacity) {
        if (name != null) {
            this.name = name;
        }
        if (pricePerDay != null) {
            this.pricePerDay = pricePerDay;
        }
    }

    public void rent() {
        if (!available) {
            throw new IllegalStateException("Car is not available");
        }
        this.available = false;
    }

    public void returnCar() {
        this.available = true;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }


    protected void setName(String name) {
        this.name = name;
    }

    protected void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    protected void setAvailable(boolean available) {
        this.available = available;
    }
}
