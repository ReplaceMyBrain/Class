package com.javalec.base;

import java.util.Scanner;

public class Ex_7 {

	public static void main(String[] args) {
		
		//선언
		Scanner scanner = new Scanner(System.in);	
		int order=0, i=0, location=0, insert=0; 
		int[] num = new int[100];
		
		//처리
		System.out.print("입력할 숫자의 갯수? :");
			order=scanner.nextInt();
			
			
		System.out.println(order + "개의 숫자를 입력하세요!:");
		for(i=0; i<order; i++) {
			System.out.print((i+1)+"의 숫자 :");
			num[i] = scanner.nextInt();		
		}
		
		System.out.print("숫자를 삽입하고자 하는 위치는 ? :");
			location =scanner.nextInt()-1;
			
			for(i=order; i>=location; i--) {
				num[i+1]= num[i];
			}
		
		System.out.print("삽입하고자 하는 수는 ? :");
			insert =scanner.nextInt();
			
			num[location]=insert;
			
		//출력
		System.out.println("---------결과--------");
		for(i=0; i<=order; i++) {
			System.out.println(num[i]);
		}
	}

}
