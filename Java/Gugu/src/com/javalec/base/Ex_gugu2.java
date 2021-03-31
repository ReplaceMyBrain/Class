package com.javalec.base;

import java.util.Scanner;

public class Ex_gugu2 {

	public static void main(String[] args) {
		
		//선언
		int dan = 0;
		Scanner scanner =new Scanner(System.in);
		
		//처리
		System.out.print("원하시는 단을 입력하세요 : ");
		dan = scanner.nextInt();

	    //결과
//		for(int i=1; i<=9; i +=1) {
//			if(i%2 == 0) {
//				System.out.println(dan + " X " + i + " = " + (dan*i));	
//			}else
//				System.out.println(dan + " X _ = " + (dan*i));
			
		for(int i=1; i<=9; i +=1) {
			System.out.println(dan + " X " + (i%2==0 ? i :"_" ) + " = " + (dan*i));	
				
			
		}
	}

}
