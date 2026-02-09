package com.ndt.assignment.day_9;


import java.util.*;


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
            System.out.println("Không phải số nguyên tố");
    }


    public static void Q2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n < 1 || n > 10)
            throw new IllegalArgumentException("n must be between 1 and 10");

        String[] arr = new String[]{"Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín", "Mười"};
        System.out.println(arr[n - 1]);
    }


    public static void Q3() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int sum = 0;
        for (int i = 0; i <= n; i += 2) {
            sum += i;
        }

        System.out.printf("Bai 3: %d", sum);
    }


    public static void Q4() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.printf("Bai 4: %.2f", (double) Arrays.stream(arr).sum() / n);
    }


    public static void Q5() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > min)
                min = arr[i];
            else
                max = arr[i];
        }

        System.out.printf("Bai 5: max: %d, min: %d", min, max);
    }


    public static void Q6() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Chieu rong hinh vuong: ");
        double n = sc.nextDouble();

        System.out.printf("Bai 6: dien tich: %f, chu vi: %f", Math.pow(n, 2), n * 4);
    }


    public static void Q7() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Bai 7: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void Q8() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Bai 8: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    static void main() {
        Q1();
        Q11();
        Q12();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
        Q7();
        Q8();
    }
}
