package com.ndt.day_7;

import java.util.*;


public class Array {
    static void demoArrayList() {
        List<String> nameLst = new ArrayList<>();

        nameLst.add("Nguyen Van A");
        nameLst.add("Tran Thi B");

        nameLst.forEach(System.out::println);
    }


    static void findMax() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Array size: ");
        int[] arr = new int[sc.nextInt()];

        System.out.println("Array elements: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            if (ele > max) {
                max = ele;
            }
        }
    }


    static void main() {
        int[] numArr = new int[5];
        numArr[0] = 2;
        numArr[3] = 150;
        System.out.printf("Kiem tra: %d\n", numArr[0]);

        Scanner sc = new Scanner(System.in);
        String[] strArr = new String[8];
        for (int i = 0; i < strArr.length; i++) {
            System.out.printf("Nhap phan tu thu %d: ", i);
            strArr[i] = sc.nextLine();
        }

        System.out.println(Arrays.toString(strArr));

        findMax();
        demoArrayList();
    }
}
