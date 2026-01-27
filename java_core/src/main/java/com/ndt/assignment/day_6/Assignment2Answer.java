package com.ndt.assignment.day_6;

import java.util.Random;
import java.util.Scanner;


public class Assignment2Answer {
    static void Q1() {
        int rand = new Random().nextInt(2);

        System.out.println("Question 1:");
        if (rand == 0) {
            int i = 0;
            while (i <= 100){
                System.out.printf("%d ", i);
                i++;
            }
        } else {
            for (int i = 0; i <= 100; i+=2)
                System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println();
    }


    static void Q2() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        long sum = 0;
        int random = new Random().nextInt(2);
        if (random == 0) {
            int i = 0;
            while (i <= n) {
                if (i % 2 == 0)
                    sum += i;

                i++;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0)
                    sum += i;
            }
        }

        System.out.println("Question 2:");
        System.out.println(sum);
        System.out.println();
    }


    static void Q3() {
        int random = new Random().nextInt(2);

        int counter = 0;
        if (random == 0) {
            int i = 0;
            while (i <= 1000){
                if (i % 3 == 0)
                    counter++;

                i++;
            }
        } else {
            for (int i = 0; i <= 1000; i++){
                if (i % 3 == 0)
                    counter++;
            }
        }

        System.out.println("Question 3:");
        System.out.println(counter);
    }


    static void main() {
        Q1();
        Q2();
        Q3();
    }
}
