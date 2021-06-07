package com.javalec.base;

import java.util.Scanner;

public class Ex_while {

	public static void main(String[] args) {
	
		//선언
		Scanner scanner =new Scanner(System.in);
		int sum = 0; //합계
		int count = 1; // 적는 갯수
		
		//처리
		System.out.print("몇개의 숫자를 더할까요?");
		int num =scanner.nextInt();
		
		System.out.println(num + "의 숫자를 입력하세요");
		
		while(count<=num) {
			sum += scanner.nextInt();
			count++;
			}
		
		scanner.close();
		
		//출력
		System.out.println("입력한 숫자의 합은 " + sum + "입니다.");
	}

}
