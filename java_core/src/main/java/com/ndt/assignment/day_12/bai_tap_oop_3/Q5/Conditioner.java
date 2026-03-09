package com.ndt.assignment.day_12.bai_tap_oop_3.Q5;

public class Conditioner extends ElectricDevice {
    public Conditioner() {
    }


    public Conditioner(String functionality, double power) {
        super(functionality, power);
    }


    public void superCool() {
        System.out.println("Super cool mode is turning on");
    }
}
