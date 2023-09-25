package org.company;

import org.company.Enums.CargoTypeEnum;

public class Request {
    private String destination;
    private int cargoQuantity;
    private CargoTypeEnum type;

    public Request(String destination, int cargoQuantity, CargoTypeEnum type) {
        this.destination = destination;
        this.cargoQuantity = cargoQuantity;
        this.type = type;
    }
}
