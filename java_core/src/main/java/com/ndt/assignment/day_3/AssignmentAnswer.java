package com.ndt.assignment.day_3;

import java.util.*;


public class AssignmentAnswer {
    static void Q1(
        Double first_side,
        Double second_side
    ){
        /*
            Inp:
                first_side (double)
                second_side (double)

            Sol:
                assign the default value if null
                check first_side, second_side > 0
                hyp = pow(first_side, 2) + pow(second_side, 2)

            Out:
                length of hypotenuse
         */
        first_side = Objects.requireNonNullElse(first_side, 3.);
        second_side = Objects.requireNonNullElse(second_side, 4.);

        if (first_side <= 0 || second_side <= 0) {
            throw new IllegalArgumentException("Side length must be > 0");
        }

        double hyp = Math.pow(first_side, 2) + Math.pow(second_side, 2);

        System.out.println("Question 1:");
        System.out.println("Hypotenuse length is: " + Math.sqrt(hyp));
        System.out.println();
    }

    static void Q2(
        Double a,
        Double x,
        Integer n
    ){
        /*
            Inp:
                a (double): coefficient
                x (int): variable
                n (int): power degree

            Sol:
                verify n is a non-negative num
                compute ax^n expr

            Out:
                value of expression P(x) = ax^n
         */
        a = Objects.requireNonNullElse(a, 1.);
        x = Objects.requireNonNullElse(x, 1.);
        n = Objects.requireNonNullElse(n, 1);

        if (n < 0)
            throw new IllegalArgumentException("x must be non-negative");

        System.out.println("Question 2:");
        System.out.printf("P(x) = %.2f\n", a * Math.pow(x, n));
        System.out.println();
    }

    static void Q3(){
        /*
            Inp:
                pos num from keyboard with 2 digits

            Sol:
                maxDigits = (int) log10(n) + 1

                loop all digit:
                    curDigit = n / pow(10, i)
                    n -= curDigit * pow(10, i)
                    sum digits += curDigit

            Out:
                sum of 2 digits of n
         */
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a positive number with 2 digits: ");
        int n = sc.nextInt();

        if (n < 0)
            throw new IllegalArgumentException("n must be positive");


        int maxDigits = (int) Math.log10(n) + 1;

        byte sum = 0;
        for (int i = maxDigits-1; i >= 0 ; i--) {
            byte curDigit = (byte) (n / Math.pow(10, i));
            n -= curDigit * (int) Math.pow(10, i);

            sum += curDigit;
        }

        System.out.println("Question 3:");
        System.out.println("Sum digits of n: " + sum);
        System.out.println();

        sc.close();
    }

    static void Q4(){
        /*
            Inp:
                5 nums from the keyboard

            Sol:
                sum with "+=" op
                take mean with "/=" op

            Out:
                mean of 5 nums
         */
        double[] nums = new double[5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < nums.length; i++) {
            String postFix = switch (i){
                case 0 -> "st";
                case 1 -> "nd";
                case 2 -> "rd";
                default -> "th";
            };

            System.out.printf("Enter %d%s num: ", i+1, postFix);
            nums[i] = sc.nextDouble();
        }

        double mean = 0.;
        for (double num : nums) {
            mean += num;
        }
        mean /= nums.length;

        System.out.println("Question 4:");
        System.out.printf("Mean of 5 nums: %.2f\n", mean);
        System.out.println();
    }

    static void Q5(){
        /*
            Inp:
                temp in Celsius from keyboard

            Sol:
                F = C * 1.8 + 32

            Out:
                converted temp in a Fahrenheit scale
         */
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature in Celsius: ");
        double temperature = sc.nextDouble();

        System.out.println("Question 5:");
        System.out.println("Temperature in Fahrenheit: " + (temperature * 1.8 + 32));
    }

    static void Q6(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter USD value: ");
        double val = sc.nextDouble();

        if (val < 0)
            throw new IllegalArgumentException("Input val must be >= 0");

        final double EXCHANGE_RATE = 23.500;
        System.out.println("Question 6:");
        System.out.printf("%.3f USD is %.3f VND\n", val, val * EXCHANGE_RATE);
        System.out.println();
    }

    static void main() {
        Q1(null, null);
        Q2(1., 2., 2);
        Q3();
        Q4();
        Q5();
        Q6();
    }
}
