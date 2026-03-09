package com.ndt.assignment.day_12.bai_tap_oop_3.Q1;

import java.util.List;


public class Student {
    String id;

    String name;

    int age;

    double mathScore;

    double englishScore;

    double scienceScore;


    public Student() {

    }


    public Student(String id, String name, int age, double mathScore, double englishScore, double scienceScore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.scienceScore = scienceScore;
    }


    public double getAverageScore() {
        double sum = 0;

        List<Double> scores = List.of(mathScore, englishScore, scienceScore);

        return scores.stream().reduce(Double::sum).get() / scores.size();
    }


    @Override
    public String toString() {
        return "Student{" +
            "age=" + age +
            ", id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", mathScore=" + mathScore +
            ", englishScore=" + englishScore +
            ", scienceScore=" + scienceScore +
            '}';
    }
}
