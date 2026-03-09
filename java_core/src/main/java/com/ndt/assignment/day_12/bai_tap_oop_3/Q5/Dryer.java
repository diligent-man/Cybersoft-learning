package com.ndt.assignment.day_12.bai_tap_oop_3.Q5;

public class Dryer extends ElectricDevice{
    public Dryer() {
    }


    public Dryer(String functionality, double power) {
        super(functionality, power);
    }

    public void dry() {
        System.out.println("Drying");
    }
}
