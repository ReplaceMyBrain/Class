package com.javalec.calc;

import java.util.Scanner;

public class Calc {

	public static void main(String[] args) {
	
		//사용자의 입력 데이터 받기
		
		Scanner scanner =new Scanner(System.in); // java.util을 꼭 고르기! 상위에 import 뜸
		 
		System.out.print("숫자를 입력하세요 :");
		int num = scanner.nextInt(); //메소드
		
		//System.out.println("사용자 입력 숫자는 " + num + "입니다.");
		 
		/*
		 * Exercise
		 * 
		 * 숫자를 입력해주세요 : 12
		 * 
		 * 입력하신 숫자는 3의 배수 입니다.
		 * 
		 * 
		 * 숫자를 입력해주세요 : 12
		 * 
		 * 입력하신 숫자는 3의 배수가 아닙니다.
		 */
		
		//System.out.print("입력하신 숫자는 3의 배수");
		//System.out.println(num%3==0 ? "입니다." : "가 아닙니다.");
		
		System.out.println(num%2==0 ? "2의 배수" : num%3==0 ? "3의배수" : "모름");
		
		scanner.close();

	}

}




		



