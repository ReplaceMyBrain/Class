package com.javalec.base;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {
		
		//선언
		Scanner scanner = new Scanner(System.in);
		String grade = "";		//처리 결과 저장
		
	
		//처리
		System.out.print("성적을 입력하세요:");	//사용자가 성적입란 입니다.
		int score = scanner.nextInt();
		
		if (score > 100 || score < 0) 	//100점이상 0점 이하의경우 오류표기
			System.out.println("오류입니다.");
		
			else {
		
				switch (score/10) { //점수
				case 10:			//100점 A
				case 9:				//90점이상 A
					grade = "A"; 
					break;
				case 8:				//80점이상 B
					grade = "B"; 
					break;
				case 7:				//70점이상 C
					grade = "C"; 
					break;
				case 6:				//60점이상 D
					grade = "D"; 
					break;
		
				default:			//60점미만 F
					grade = "F";
					break;
				}
		
		scanner.close();
		
		//결과
		
		System.out.println("당신의 성적은 " + grade + "입니다");
		
		
		}	

	}

}
