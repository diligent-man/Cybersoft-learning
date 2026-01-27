package com.ndt.day_6;

import java.util.Scanner;


public class Loop {
    static void demoWhileDo(Scanner sc) {
        double grade = 0;
        while (grade < 5) {
            System.out.print("Enter grade: ");
            grade = sc.nextDouble();

            if (grade < 0 || grade > 10) {
                System.out.println("Invalid grade");
                grade = 0;
            }
        }

        System.out.println("You passed !");
    }


    static void demoDoWhile(Scanner sc) {
        double grade;
        do {
            System.out.print("Enter grade: ");
            grade = sc.nextDouble();

            if (grade < 0 || grade > 10) {
                System.out.println("Invalid grade");
                grade = 0;
            }
        } while (grade < 5);

        System.out.println("You passed !");
    }

    static void demoFor() {
        // print all pos num
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.printf("%d ", i);
        }
    }


    static void main() {
        // Nhap diem thi neu diem thi < 5 thi bat nhap lai
        Scanner sc = new Scanner(System.in);
        demoWhileDo(sc);
        demoDoWhile(sc);
        demoFor();
    }
}
