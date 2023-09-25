package org.company;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.security.auth.login.CredentialException;
import java.util.Random;

@Getter
@Setter
@ToString
public class Driver {
    private String name;
    private int experience;
    private Auto auto;
    private boolean isBusy;


    private int cargoCount = 0;

    private double money;

    public Driver(String name, int experience, Auto auto) {
        this.name = name;
        this.experience = experience;
        this.auto = auto;
    }

    public Driver(String name, int experience, Auto auto, int cargoCount) {
        this.name = name;
        this.experience = experience;
        this.auto = auto;
        this.cargoCount = cargoCount;
    }

    public void doRepairDestination(){
        System.out.println(new RepairRequest(auto, this).toString());
    }


    public void pathPassed(){
        Random random = new Random();
        money += random.nextDouble(100,300) * 0.35;

        System.out.println("Рейс выполнен! Состояние машины: " + auto.getCarStatus());
        cargoCount += 1;
        DBDispatch.getInstance().addPathPassedRecord(this);
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

    public boolean getIsBusy() {
        return isBusy;
    }
}
