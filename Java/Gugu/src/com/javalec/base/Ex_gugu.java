package com.javalec.base;

import java.util.Scanner;

public class Ex_gugu {

	public static void main(String[] args) {
		
		
	//원하시는 단을 입력하세요 : 7
	//짝수의 단만 입력
		
		
		//선언
		int dan = 0;	// 쓰는게 좋다. 없으면 0으로 확인.
		Scanner scanner =new Scanner(System.in);
		
		//처리
		System.out.print("원하시는 단을 입력하세요 : ");
		dan = scanner.nextInt();
//		
//		for(int i=2; i<=9; i +=2) {
//			System.out.println(dan + " X " + i + " = " + (dan*i));
//		}	
//	
	    //결과
		for(int i=1; i<=9; i +=1) {
			if(i%2 == 0) {
				System.out.println(dan + " X " + i + " = " + (dan*i));	
			}
			
		}
	
	}

}
