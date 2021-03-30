package com.javalec.base;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		int i = 10; // 코멘트 적어줘야지 소스보기가 쉬움.
		int j = 20;
		int k = 30;

//		// 비교문 #1
//		if(i > j) {
//			System.out.println("i가 j보다 큽니다.");
//			
//		}
//		
//		System.out.println(">>> End <<<");
	
		
		// 비교문 #2 : 비교문으로 입력한 숫자 크기의 차이 구하기.
		
//		if(i > j) { 
//			System.out.println("i는 j보다 " + (i-j) + "만큼 큽니다.");
//			
//		}else {
//			System.out.println("j는 i보다 " + (j-i) + "만큼 큽니다.");
//			
//		}
		
		// 비교문 #3 : 비교문으로 크다, 작다, 같다의 3종류 이상의 비교문
		
//		if(i > j) {
//			System.out.println("i가 j보다 큽니다.");
//		}else if (i==j) {
//			System.out.println("i가 j 같습니다.");
//		}else {
//			System.out.println("i가 j 작습니다.");
//		}
//		System.out.println(">>> End <<<");
		
		
//		int price = 5000;
//		
//		if(price > 8000) {	
//			System.out.println("너무 비쌉니다.");
//		}else if(price > 5000) {
//		    System.out.println("조금 비쌉니다.");	
//		}else if(price > 3000) {
//		    System.out.println("적당한 금액입니다.");	
//		}else {
//			System.out.println("싼편 입니다.");
//		}
//		
//		System.out.println("구매 하실래요?");

		
		/*
		 * 성적을 입력하세요 : 90
		 * 귀하의 학점은 A학점 입니다.
		 * 
		 * 성적을 입력하세요 : 80
		 * 귀하의 학점은 B학점 입니다.
		 * 
		 * 성적을 입력하세요 : 40
		 * 귀하의 학점은 F학점 입니다.
		 * 
		 */
		
		
		Scanner scan =new Scanner(System.in);
		System.out.print("성적을 입력하세요 : ");
		int score = scan.nextInt();
		String grade ="";
		
		
		if(score>100) grade = "error";	
		else if(score >=80) grade = "A";
		else if(score >=80)grade = "B";
		else if(score >=70) grade = "C";
		else if(score >=60) grade = "D";
		else if(score >=0)grade = "F";
		else grade = "error";
	
		
		if(grade == "error") System.out.print("점수가 잘못 입력되었습니다.");
	    else System.out.println("귀하의 학점은 " + grade + "입니다.");
		
	
		
	}

}
