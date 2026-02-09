package com.ndt.assignment.day_9;


import java.util.Scanner;


public class BaiTap8Docx {
    public static boolean isPrime(int n) {
        if (n < 2)
            return false;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }


    public static void Q1() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n >= 0)
            System.out.println("Đây là số nguyên dương");
        else
            System.out.println("Đây là số nguyên âm");
    }


    public static void Q11() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n % 2 == 0)
            System.out.println("Số lẻ");
        else
            System.out.println("Số chẵn");
    }


    public static void Q12() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isPrime(n))
            System.out.println("Số nguyên tố");
        else
            System.out.println("Không phải ố nguyên tố");

    }


    static void main() {
        Q1();
        Q11();
        Q12();
    }
}
