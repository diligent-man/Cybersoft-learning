package com.ndt.assignment.java_core.day_8;

import java.util.Scanner;


public class Q4 {
    static void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
            Pick 1 of 3 grab car:
                a/ GrabCar
                b/ Grab SUV
                c/ GrabBlack
            """);
        sc.nextLine();

        System.out.println("So KM: ");
        double km = sc.nextDouble();

        System.out.println("Thoi gian cho: ");
        int time = sc.nextInt();

        System.out.println("Tong tien di duoc: " + km * 13_000);
        System.out.println("Hoa don da in !");
    }
}
