package com.ndt.assignment.day_12.bai_tap_oop_3.Q2;


public class Car {
    String manufacturer;

    String color;

    int year;

    public Car() {

    }

    public Car(String manufacturer, String color, int year) {
        this.manufacturer = manufacturer;
        this.color = color;
        this.year = year;
    }


    @Override
    public String toString() {
        return "Car{" +
            "color='" + color + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", year=" + year +
            '}';
    }
}
