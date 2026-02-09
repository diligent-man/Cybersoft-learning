package com.ndt.assignment.day_9;

import java.util.Arrays;
import java.util.Scanner;


public class BaiTapMang2 {
    static int[] arr;


    static {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu trong mang: ");
        int n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void sort(int[] arr, boolean ascending) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (ascending) {
                    if (arr[j] < arr[i])
                        swap(arr, i, j);
                } else if (arr[j] > arr[i])
                    swap(arr, i, j);
            }
        }
    }


    public static void Q1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so thu 1: ");
        int a = sc.nextInt();

        System.out.println("Nhap so thu 2: ");
        int b = sc.nextInt();

        if (a > b)
            System.out.println("A is larger than B");
        else
            System.out.println("B is larger than A");
    }


    public static void Q2() {
        double mean = 0;
        for (int ele : arr) {
            if (ele % 2 != 0)
                mean += ele;
        }

        mean /= arr.length;
        System.out.println("Mean: " + mean);
    }


    public static void Q3() {
        int max = arr[0];
        for (int ele : arr) {
            if (ele > max)
                max = ele;
        }
        System.out.println("Max: " + max);
    }


    public static void Q4() {
        int min = arr[0];
        for (int ele : arr) {
            if (ele < min)
                min = ele;
        }
        System.out.println("Min: " + min);
    }


    public static void Q5() {
        double mean = 0;
        for (int ele : arr) {
            mean += ele;
        }

        mean /= arr.length;
        System.out.println("Mean: " + mean);
    }


    public static void Q6() {
        int counter = 0;
        for (int e : arr) {
            if (e % 2 == 0)
                counter++;
        }
        System.out.printf("Số phần tử chẵn: %d", counter);
        System.out.println();
    }


    public static void Q7() {
        int neg_counter = 0;
        int pos_counter = 0;
        int zero_counter = 0;

        for (int ele : arr) {
            if (ele < 0)
                neg_counter++;
            else if (ele > 0)
                pos_counter++;
            else
                zero_counter++;
        }

        System.out.printf("Số lượng số âm: %d\n", neg_counter);
        System.out.printf("Số lượng số dương: %d\n", pos_counter);
        System.out.printf("Số lượng số 0: %d\n", zero_counter);
    }


    public static void Q8() {
        int counter = 0;

        for (int i = 0; i < arr.length; i += 2) {
            counter++;
        }

        System.out.printf("Số lượng phần tử ở vị trí chẵn: %d\n", counter);
    }


    public static void Q9() {
        int counter = 0;

        for (int i = 1; i < arr.length; i += 2) {
            counter++;
        }

        System.out.printf("Số lượng phần tử ở vị trí lẻ: %d\n", counter);
    }


    public static void Q10() {
        boolean flag = false;

        for (int e : arr) {
            if (e > 10) {
                flag = true;
                break;
            }
        }

        if (flag)
            System.out.println("Có phần tử đầu tiên lớn hơn 10");
        else
            System.out.println("Không có phần tử đầu tiên lớn hơn 10");
    }


    public static void Q11() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập x: ");
        int x = sc.nextInt();

        int counter = 0;
        for (int e : arr) {
            if (e == x)
                counter++;
        }

        System.out.printf("Số lần %d xuất hiện là %d\n", x, counter);
    }


    public static void Q12() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập x: ");
        int x = sc.nextInt();

        boolean flag = false;
        for (int e : arr) {
            if (e == x) {
                flag = true;
                break;
            }
        }

        if (flag)
            System.out.printf("%d có xuất hiện trong mảng\n", x);
        else
            System.out.printf("%d không có xuất hiện trong mảng\n", x);
    }


    public static void Q13() {
        int[] reversed_arr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            reversed_arr[i] = arr[arr.length - i - 1];
        }

        System.out.printf("Reversed arr: %s", Arrays.toString(reversed_arr));
        System.out.println();
    }


    public static void Q14() {
        int[] copied_arr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copied_arr[i] = arr[i];
        }
        System.out.printf("Copied arr: %s", Arrays.toString(copied_arr));
    }


    public static void Q15() {
        int[] copiedArr = new int[arr.length];
        System.arraycopy(arr, 0, copiedArr, 0, arr.length);
        sort(copiedArr, true);
        System.out.printf("Ascending sorted array: %s\n", Arrays.toString(copiedArr));
    }


    public static void Q16() {
        int[] copiedArr = new int[arr.length];
        System.arraycopy(arr, 0, copiedArr, 0, arr.length);
        sort(copiedArr, false);
        System.out.printf("Descending sorted array: %s\n", Arrays.toString(copiedArr));
    }


    public static void Q17() {
        int sum = 0;
        for (int e : arr) {
            if (e % 3 == 0)
                sum += e;
        }
        System.out.printf("Sum: %d\n", sum);
    }


    public static void Q18() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vị trí để xóa: ");
        int idx = sc.nextInt();

        if (idx < 0 || idx >= arr.length) {
            throw new IllegalArgumentException("Index out of bounds");
        }

        int[] newArr = new int[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i == idx)
                continue;
            newArr[i] = arr[i];
        }
    }


    public static void Q19() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử mảng thứ 2: ");
        int n = sc.nextInt();

        int[] secondArr = new int[n];
        for (int i = 0; i < n; i++) {
            secondArr[i] = sc.nextInt();
        }


        int[] mergedArr = new int[arr.length + secondArr.length];
        int i = 0, j = 0;
        while (i < arr.length || j < secondArr.length) {
            if (i < arr.length)
                mergedArr[i] = arr[i++];
            else
                mergedArr[i + j] = secondArr[j++];
        }

        System.out.printf("Merged array: %s", Arrays.toString(mergedArr));
    }


    public static void Q20() {
        int l = 0;
        int r = 1;

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > arr[r])
                r = i;

            if (arr[i] > arr[l] && i < arr.length - 1){
                l = r;
                r = i;
            }
        }

        System.out.println(arr[l] + arr[r]);
    }


    static void main() {
        Q1();
        Q2();
        Q3();
        Q4();
        Q5();
        Q6();
        Q7();
        Q8();
        Q9();
        Q10();
        Q11();
        Q12();
        Q13();
        Q14();
        Q15();
        Q16();
        Q17();
        Q18();
        Q19();
        Q20();
    }
}
