package org.example;

public class RepairRequest {
    private Auto auto;
    private Driver driver;

    public RepairRequest(Auto auto, Driver driver) {
        this.auto = auto;
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Этот водитель починки просит! " + driver.toString();
    }

    public Auto getAuto() {
        return auto;
    }

    public Driver getDriver() {
        return driver;
    }


}
