package com.javalec.base;

import java.util.Scanner;

public class Ex_1 {

	public static void main(String[] args) {
	
		//선언
		Scanner scanner = new Scanner(System.in);
		long num = 1;
	
		//처리
		System.out.print("숫자를 입력해주세요.");
		long input = scanner.nextLong();
		
		for(int i=0; i<=10; i++) {
		
		//결과	
			System.out.println(input+"^" +String.format("%2d", i)+ " = " + String.format("%13d", num));
			num *= input;
				
		
		}
	}

}
