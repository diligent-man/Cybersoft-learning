package com.ndt.assignment.day_12.bai_tap_huong_doi_tuong.Q1;

import java.util.*;


public class Main {
    static void _run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter student id: ");
        String id = sc.nextLine();

        System.out.println("Enter student name: ");
        String name = sc.nextLine();

        System.out.println("Enter student math score: ");
        double math = sc.nextInt();

        System.out.println("Enter student physics score: ");
        double physics = sc.nextInt();

        System.out.println("Enter student chemistry score: ");
        double chemistry = sc.nextInt();

        Map<String, Double> scores = new HashMap<>();
        scores.put("math", math);
        scores.put("physics", physics);
        scores.put("chemistry", chemistry);

        Student student = new Student(id, name, scores);

        System.out.println(student);
        System.out.printf("GPA is: %.2f\n", student.getAverageScore());
        System.out.printf("This student is ranked as \"%s\"\n\n\n", student.rankStudent());
    }


    static void main() {
        Scanner sc = new Scanner(System.in);
        char opt;

        while (true) {
            System.out.print("Do you want to continue? (y/n): ");

            opt = sc.next().charAt(0);
            if (opt == 'y')
                _run();
            else {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
