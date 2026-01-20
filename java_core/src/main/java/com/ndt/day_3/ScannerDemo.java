package com.ndt.day_3;

import java.util.Scanner;


public class ScannerDemo {
	static void main() {
		Scanner sc = new Scanner(System.in);

//		System.out.printf("Ho Ten: ");
//		String name = sc.nextLine();
//		System.out.println(name);
		
		System.out.println("Nhap so thu 1: ");
		int firstNum = Integer.parseInt(sc.nextLine());
		
		System.out.println("Nhap so thu 2: ");
		int secondNum = Integer.parseInt(sc.nextLine());
		
		sc.close();
	}
}
