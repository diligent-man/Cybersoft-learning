package com.ndt.day_8;


import java.util.Scanner;


public class Function {
    /*
        Có 2 loại hàm
            + hàm có giá trị trả về
            + hàm không có giá trị trả về
     */
    public static void calSum2Num(int thamSoA, int thamSoB){
        int soA = thamSoA;
        int soB = thamSoB;
        int result = soA + soB;
        System.out.printf("Sum of 2 numbers: %d\n", result);
    }

    public static int calProduct2Num (int soA, int soB){
        int result = soA * soB;
        System.out.println("Product of 2 numbers: " + result);
        return result;
    }


    static void findMaxOfThree(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 3 numbers: ");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max = Math.max(a, Math.max(b, c));
        System.out.println("Max of 3 numbers: " + max);

        sc.close();
    }
    static void main() {
        // call fn
        // calSum2Num(5, 3);
        // calSum2Num(calProduct2Num(2, 5), calProduct2Num(3, 3));
        findMaxOfThree();
    }
}
