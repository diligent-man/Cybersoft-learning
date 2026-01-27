package com.ndt.assignment.day_5;

import java.util.*;


public class Assignment1Answer {
    static void Q1() {
        /*
            Inp:
                positive num m, n

            Sol:
                compare m vs n

            Out:
                the larger num
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter m: ");
        int m = sc.nextInt();

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        if (m > n)
            System.out.println("m is larger than n");
        else
            System.out.println("n is larger than m");
    }


    static void Q2() {
        /*
            Inp:
                num1, num2, num3 are int

            Sol:
                case 1: if num1 is the largest
                    if num2 > num3
                        num3 -> num2 -> num1
                    else
                        num3 -> num2 -> num1


                case 2: if num2 is the largest
                    if num1 > num3
                        num3 -> num1 -> num2
                    else
                        num1 -> num3 -> num2


                case 3: if num3 is the largest
                    if num1 > num2
                        num2 -> num1 -> num3
                    else
                        num1 -> num2 -> num3

            Out:
                Ascending order of num1, num2, and num3
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first num");
        int num1 = sc.nextInt();

        System.out.println("Enter second num");
        int num2 = sc.nextInt();

        System.out.println("Enter third num");
        int num3 = sc.nextInt();

        if (num1 > num2 && num1 > num3) {
            if (num2 > num3)
                System.out.printf("%d - %d - %d", num3, num2, num1);
            else
                System.out.printf("%d - %d - %d", num2, num3, num1);
        } else if (num2 > num1 && num2 > num3) {
            if (num1 > num3)
                System.out.printf("%d - %d - %d", num3, num1, num2);
            else
                System.out.printf("%d - %d - %d", num1, num3, num2);
        } else {
            if (num1 > num2)
                System.out.printf("%d - %d - %d", num2, num1, num3);
            else
                System.out.printf("%d - %d - %d", num1, num2, num3);
        }
    }


    static void Q3() {
        /*
            Inp:


            Sol:
                check opt:
                    1: for ascending order
                    2: for descending order
                    other: promt err

                the rest is similar to Q2

            Out:
                Ascending or Descending order of num1, num2, num3
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter option to run:" +
            "1: for print ascending order" +
            "2: for print descending order"
        );
        int opt = sc.nextInt();

        if (!(opt == 1 || opt == 2)) {
            throw new IllegalArgumentException("Invalid option");
        }

        System.out.println("Enter first num");
        int num1 = sc.nextInt();

        System.out.println("Enter second num");
        int num2 = sc.nextInt();

        System.out.println("Enter third num");
        int num3 = sc.nextInt();

        if (opt == 1) {
            if (num1 > num2 && num1 > num3) {
                if (num2 > num3)
                    System.out.printf("%d - %d - %d", num3, num2, num1);
                else
                    System.out.printf("%d - %d - %d", num2, num3, num1);
            } else if (num2 > num1 && num2 > num3) {
                if (num1 > num3)
                    System.out.printf("%d - %d - %d", num3, num1, num2);
                else
                    System.out.printf("%d - %d - %d", num1, num3, num2);
            } else {
                if (num1 > num2)
                    System.out.printf("%d - %d - %d", num2, num1, num3);
                else
                    System.out.printf("%d - %d - %d", num1, num2, num3);
            }
        } else {
            if (num1 > num2 && num1 > num3) {
                if (num2 > num3)
                    System.out.printf("%d - %d - %d", num1, num2, num3);
                else
                    System.out.printf("%d - %d - %d", num1, num3, num2);
            } else if (num2 > num1 && num2 > num3) {
                if (num1 > num3)
                    System.out.printf("%d - %d - %d", num2, num1, num3);
                else
                    System.out.printf("%d - %d - %d", num2, num3, num1);
            } else {
                if (num1 > num2)
                    System.out.printf("%d - %d - %d", num3, num1, num2);
                else
                    System.out.printf("%d - %d - %d", num3, num2, num1);
            }
        }
    }


    static void Q4() {
        /*
            Inp:
                int num

            Sol:
                verify n is 2-digit num

                traverse each digit of n
                    if curDigit == 1
                        if pos == 1
                            "mười"
                        else
                            "một"

                    if curDigit in {0, 2, 3, ..., 9}
                        pronounce as is

                    update num by:
                        num -= curDigit * (int) Math.pow(10, pos)

                    if (pos == 1) {
                        if (curDigit > 1)
                            result.append("mươi ");

                    if num == 0
                        break
            Out:
                pronunciation of num
         */
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter num: ");
        int num = sc.nextInt();

        int maxDigits = (int) Math.log10(num) + 1;

        if (maxDigits > 2) {
            System.out.println("Not a 2-digit number");
            System.exit(-1);
        }

        StringBuilder result = new StringBuilder();
        for (int pos = maxDigits - 1; pos >= 0; pos--) {
            int curDigit = (int) (num / Math.pow(10, pos));

            switch (curDigit) {
                case 1 -> {
                    if (pos == 1)
                        result.append("mười ");
                    else
                        result.append("một");
                }
                case 2 -> result.append("hai ");
                case 3 -> result.append("ba ");
                case 4 -> result.append("bốn ");
                case 5 -> result.append("năm ");
                case 6 -> result.append("sáu ");
                case 7 -> result.append("bảy ");
                case 8 -> result.append("tám ");
                case 9 -> result.append("chín ");
                default -> result.append("không ");
            }

            // update num
            num -= curDigit * (int) Math.pow(10, pos);

            // pronounce multiplier
            if (pos == 1) {
                if (curDigit > 1)
                    result.append("mươi ");
            }

            if (num == 0)
                break;
        }

        System.out.println(result);
    }


    static void Q5() {
        /*
            Inp:
                opt

            Sol:
                switch to appropriate family member for greeting

            Out:
                greeting to input opt
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("Ban la ai: ");
        String opt = sc.nextLine();

        switch (opt) {
            case "B" -> System.out.println("Chao bo");
            case "H" -> System.out.println("Chao me");
            case "A" -> System.out.println("Chao anh trai");
            case "E" -> System.out.println("Chao em gai");
            default -> throw new IllegalArgumentException("Invalid input");
        }
    }


    static void main() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
    }
}
