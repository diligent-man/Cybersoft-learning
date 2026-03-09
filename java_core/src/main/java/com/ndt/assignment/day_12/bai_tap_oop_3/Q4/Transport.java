package com.ndt.assignment.day_12.bai_tap_oop_3.Q4;


public class Transport {
    String color;

    String manufacturer;

    int year;

    public Transport() {
    }

    public Transport(String color, String manufacturer, int year) {
        this.color = color;
        this.manufacturer = manufacturer;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Transport{" +
            "color='" + color + '\'' +
            ", manufacturer='" + manufacturer + '\'' +
            ", year=" + year +
            '}';
    }
}
