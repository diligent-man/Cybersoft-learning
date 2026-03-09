package com.ndt.assignment.day_12.bai_tap_huong_doi_tuong.Q2;

import java.util.HashMap;
import java.util.Map;


public class Student {
    String id;

    String name;

    Map<String, Double> score = new HashMap<>();


    public Student() {

    }


    public Student(String id, String name, Map<String, Double> score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Map<String, Double> getScore() {
        return score;
    }


    public void setScore(Map<String, Double> score) {
        this.score = score;
    }


    public double getAverageScore() {
        double sum = 0;
        for (double score : this.score.values()) {
            sum += score;
        }
        return sum / this.score.size();
    }


    public String rankStudent() {
        double gpa = getAverageScore();
        String rank = "yếu";

        if (gpa >= 9) {
            rank = "xuất sắc";
        } else if (gpa >= 8) {
            rank = "giỏi";
        } else if (gpa >= 7) {
            rank = "khá";
        } else if (gpa >= 6) {
            rank = "trung bình";
        }

        return rank;
    }


    @Override
    public String toString() {
        return "Student{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", score=" + score +
            '}';
    }
}
