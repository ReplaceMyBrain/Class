package com.javalec.base;
 
import java.util.Scanner;

public class Ex_gugu1 {

	public static void main(String[] args) {
		
		Scanner scanner =new Scanner(System.in);
		int temp = 0;
		
		System.out.print("구구단 시작 범위 입력 : ");
		int startdan = scanner.nextInt();
		System.out.print("구구단 끝 범위 입력 : ");
		int enddan =scanner.nextInt();
		
		//시작과 끝을 자동으로 변환
		if(startdan>enddan) {
			temp = startdan;
			startdan = enddan;
			enddan = temp;
		}
		for(int dan=startdan; dan<=enddan; dan++) {
			System.out.println("--------" +dan+ "단------------");
			
			for(int i=(dan%2==0 ? 2:1); i<=9; i+=2) {
				System.out.println(dan + " X " + i + " = " + String.format("%2d",(dan*i)));
				}
		}
		
		scanner.close();
		
		// 사용자의 입력정보 Check
//		if(startdan>enddan) {
//			System.out.println("입력 정보를 확인하세요");
//		}else {
//			for(int dan=startdan; dan<=enddan; dan++) {
//				System.out.println("--------" +dan+ "단------------");
//				for(int i=1; i<=9; i++) {
//					System.out.println(dan + " X " + i + " = " + String.format("%2d",(dan*i)));
//				}
//				
//			}
		
//			
//		}
		

	}

}
