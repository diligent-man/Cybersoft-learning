package com.ndt.assignment.day_6;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;


public class Assignment1Answer {
    static void Q1() {
        // {0,1,2} == {"kéo", "búa", "bao"}
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int opt = 1;
        String msg = """
            Your choice:
            1/ play
            2/ exit
            """;

        while (opt == 1) {
            int computerChoice = rand.nextInt(3);

            System.out.println("""
                1/ Rock
                2/ Scissor
                3/ Paper
                """);
            int playerChoice = rand.nextInt(3);

            // if (computerChoice == 1) {
            //     if (playerChoice == 1)
            //         System.out.println("Tie");
            //     else if (playerChoice == 2)
            //         System.out.println("Lose");
            //     else
            //         System.out.println("Win");
            // } else if (computerChoice == 2)
            //     if (playerChoice == 1)
            //         System.out.println("Lose");
            //     else if (playerChoice == 2)
            //         System.out.println("Tie");
            //     else
            //         System.out.println("Lose");
            // }
            // opt = sc.nextInt();

        }
    }


    static void Q2() {
        int n = 1;
        int sum = 0;
        while (sum <= 10_000) {
            sum += n;
            n++;
        }

        System.out.println("Question 2:");
        System.out.printf("n is %d\n\n", n);
    }


    static void Q3() {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (n <= 0) {
            System.out.print("Enter a number larger than 0: ");
            n = sc.nextInt();
        }

        int sum = 0;
        for (int i = 1; i < n; i += 2)
            sum += i;

        System.out.println("Question 3:");
        System.out.printf("Sum of odd: %d\n\n", sum);
    }


    static void Q4() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int n = sc.nextInt();

        int x = 2;
        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= n; i++)
            sum = sum.add(BigInteger.valueOf((long) Math.pow(x, i)));

        System.out.println("Question 4:");
        System.out.printf("Sum of S(%d): %s\n\n", n, sum);
    }


    static void Q5() {
        double principal = 100000.;
        double desiredVal = principal * 100;
        double interest = .05;

        double actualVal = principal;
        int year = 0;
        while (actualVal <= desiredVal) {
            actualVal += actualVal * interest;
            year++;
            System.out.println(actualVal);
        }

        System.out.println("Question 5:");
        System.out.printf("Year to wait: %d", year);
    }

    static void sum(int a){
        a += 10;
    }

    static void main() {
        // Q1();
        // Q2();
        // Q3();
        // Q4();
        // Q5();
    }
}
