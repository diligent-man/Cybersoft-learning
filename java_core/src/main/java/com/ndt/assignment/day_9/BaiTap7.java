package com.ndt.assignment.day_9;


import java.util.Scanner;


public class BaiTap7 {
    static void Q1() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input a: ");
        int a = sc.nextInt();
        System.out.print("Input b: ");
        int b = sc.nextInt();

        System.out.println("Sum a + b = " + (a + b));
    }


    static void Q2() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Input w: ");
        int w = sc.nextInt();
        System.out.print("Input h: ");
        int h = sc.nextInt();

        System.out.println("Rectangle Area: " + (w * h));
    }


    static void Q3() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input a: ");
        int a = sc.nextInt();

        System.out.print("Cubic volume is: " + Math.pow(a, 3));
    }


    static void Q5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Sum from 1 to N is " + sum);
    }


    static void Q6() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input n: ");
        int n = sc.nextInt();

        if (n % 2 == 0) {
            System.out.println("Input n is even");
        } else {
            System.out.println("Input n is odd");
        }
    }


    static void Q7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input num eles: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("Input %d-th ele: ", i + 1);
            arr[i] = sc.nextInt();
        }

        int oddCounter = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                oddCounter++;
            }
        }

        int evenCounter = arr.length - oddCounter;

        System.out.println("Num odd number is: " + oddCounter);
        System.out.println("Num even number is: " + evenCounter);
    }


    static void main() {
        Q1();
        Q2();
        Q3();
        Q5();
        Q6();
        Q7();
    }
}

