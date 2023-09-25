package org.company;

import org.company.Enums.CargoTypeEnum;

public class Auto {
    private String destination;
    private int cargoQuantity;
    private CargoTypeEnum type;

    private Driver driver;

    private float carStatus;

    public Auto(String destination, int cargoQuantity, CargoTypeEnum type, float carStatus) {
        this.destination = destination;
        this.cargoQuantity = cargoQuantity;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "destination='" + destination + '\'' +
                ", cargoQuantity=" + cargoQuantity +
                ", type=" + type +
                ", driver=" + driver +
                ", carStatus=" + carStatus +
                '}';
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public void setCargoQuantity(int cargoQuantity) {
        this.cargoQuantity = cargoQuantity;
    }

    public CargoTypeEnum getType() {
        return type;
    }

    public void setType(CargoTypeEnum type) {
        this.type = type;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public float getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(float carStatus) {
        this.carStatus = carStatus;
    }
}
