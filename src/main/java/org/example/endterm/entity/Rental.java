package org.example.endterm.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "rentals")
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Car car;

    private int customerId;
    private LocalDate startDate;
    private LocalDate endDate;

    public Rental() {}

    public Rental(Car car, int customerId, LocalDate startDate, LocalDate endDate) {
        this.car = car;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
