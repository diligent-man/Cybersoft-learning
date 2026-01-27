package com.ndt.assignment.day_5;


import java.util.Scanner;


public class Assignment2Answer {
    static void main() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Name: ");
        String name = sc.nextLine();

        System.out.println("Math grade: ");
        double mathGrade = sc.nextDouble();

        System.out.println("Physics grade: ");
        double physGrade = sc.nextDouble();

        System.out.println("Chemistry grade: ");
        double chemGrade = sc.nextDouble();

        String rank;
        double avg = (mathGrade + physGrade + chemGrade) / 3;

        if (avg < 5) {
            rank = "Weak";
        } else if (avg < 6.5) {
            rank = "Average";
        } else if (avg < 8.5) {
            rank = "Fair";
        } else {
            rank = "Good";
        }

        System.out.printf("Name: %s (%s)", name, rank);
    }
}
