package org.company;

import org.company.Enums.CargoTypeEnum;

public class Base {
    public static void main(String[] args) {
        Auto auto = new Auto("Европа", 100, CargoTypeEnum.BULK, 100.0F);
        Driver driver = new Driver("Василий", 13, auto);

        driver.pathPassed();

        driver.setAuto(auto);
        driver.pathPassed();

        driver.setAuto(auto);
        driver.pathPassed();


        DBDispatch.getInstance().createMoneyTop(driver);
        String mostRichDriver = DBDispatch.getInstance().getMostRichDriver();
        System.out.println(mostRichDriver);
    }
}