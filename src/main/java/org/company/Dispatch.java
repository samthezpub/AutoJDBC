package org.company;

import org.company.Enums.CargoTypeEnum;
import org.company.Exceptions.NoDriversAvailableException;

import java.util.List;

public class Dispatch {

    public Request doRequest(String destination, int cargoQuantity, CargoTypeEnum type) {
        return new Request(destination, cargoQuantity, type);
    }

    public Driver driverDistribution(List<Driver> drivers, Request request, int experience) {
        try {
            for (int i = 0; i < drivers.size(); i++) {
                Driver driver = drivers.get(i);

                if (driver.getExperience() >= experience && !driver.getIsBusy()) {
                    return driver;
                }
            }
            throw new NoDriversAvailableException("Нет доступных водителей");
        }
        catch (NoDriversAvailableException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
