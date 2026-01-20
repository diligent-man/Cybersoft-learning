package com.ndt.day_3;


public class Variable {
	static void main() {
		/*
			Error types:
				a/ compile error
					e.g syntax error, type mismatch, etc.
				b/ runtime error
					e.g. logic-related errors
			
			Naming convention
				var name: camelCase
				class name: CamelCase
				package name: snake_case
		*/
		byte age = 20;
		int soA = 1000;
		int result = soA + age;
		
		char c = 'A';
		
		String chuoi = "Nguyen Van A";
		String chuoi2 = "Lop BC12";
		
		System.out.println("Kiem tra " + result);
		System.out.println(chuoi);
	}
}
