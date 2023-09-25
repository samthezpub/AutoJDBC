package org.example;

import java.util.Random;

public class Driver {
    private int experience;
    private Auto auto;
    private boolean isBusy;

    private double money;
    public Driver(int experience, Auto auto) {
        this.experience = experience;
        this.auto = auto;
    }

    public void doRepairDestination(){
        System.out.println(new RepairRequest(auto, this).toString());
    }

    public void pathPassed(){
        Random random = new Random();
        money += random.nextDouble(100,300) * 0.35;

        System.out.println("Рейс выполнен! Состояние машины: " + auto.getCarStatus());
        freeAuto();
    }

    public void freeAuto()
    {
        auto.setDriver(null);
        auto.setCargoQuantity(0);
        auto.setDestination(null);
        auto.setType(null);

        this.auto = null;
        this.isBusy = false;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "experience=" + experience +
                ", auto=" + auto +
                ", isBusy=" + isBusy +
                auto.toString() +
                '}';
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public boolean getIsBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setIsBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }
}
