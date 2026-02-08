package org.example.endterm.patterns;

import org.example.endterm.entity.*;

public class CarFactory {

    public static Car createCar(String type) {
        return switch (type.toLowerCase()) {
            case "electric" -> new ElectricCar();
            case "gas" -> new GasCar();
            default -> throw new IllegalArgumentException("Unknown car type: " + type);
        };
    }
}


