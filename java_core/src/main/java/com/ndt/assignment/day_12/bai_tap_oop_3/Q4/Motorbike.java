package com.ndt.assignment.day_12.bai_tap_oop_3.Q4;


public class Motorbike extends Transport {
    int wheels = 2;


    public Motorbike() {
    }


    public Motorbike(int wheels) {
        this.wheels = wheels;
    }


    public Motorbike(String color, String manufacturer, int year, int wheels) {
        super(color, manufacturer, year);
        this.wheels = wheels;
    }


    @Override
    public String toString() {
        return "Motorbike{" +
            "wheels=" + wheels +
            ", color='" + color + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", year=" + year +
            '}';
    }
}
