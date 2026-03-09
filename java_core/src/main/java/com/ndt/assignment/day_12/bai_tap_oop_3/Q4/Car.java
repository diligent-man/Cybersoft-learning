package com.ndt.assignment.day_12.bai_tap_oop_3.Q4;


public class Car extends Transport {
    int wheels = 4;


    public Car() {
    }


    public Car(int wheels) {
        this.wheels = wheels;
    }


    public Car(String color, String manufacturer, int year, int wheels) {
        super(color, manufacturer, year);
        this.wheels = wheels;
    }


    @Override
    public String toString() {
        return "Car{" +
            "wheels=" + wheels +
            ", color='" + color + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", year=" + year +
            '}';
    }
}
