package com.javalec.base;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		// if 보다는 switch가 가독성이 좋다. 
		// java에서는 switch기능이 떨어진다.
		
		// if문과 switch
		// 선언문
		Scanner scanner = new Scanner(System.in);
		int inputNumver = 0;	//사용자 입력
		String result = "";		//처리 결과 저장
		
		// 처리
		System.out.print("숫자를 입력하세요!");
		inputNumver = scanner.nextInt();
		
//		if(inputNumver % 2 == 0) { //짝수 판단
//			result = "짝수";
//		}else { //홀수판단
//			result = "홀수";
			
		switch(inputNumver % 2) {
			case 0:
				result = "짝수";
				break;
			case 1:
				result = "홀수";
				break;
			default :
				break;
		}
		scanner.close();
		
		/* ----------------------
		 * 2021.03.31 DW
		 * 기능 : 결과보여주기
		 * ----------------------
		 */
		// 결과보여주기
		System.out.println("입력하신 숫자 " + inputNumver + "는 " + result + "입니다");
		
	}

}

       
		