package com.javalec.base;

import java.util.Scanner;



public class Main {

	public static void main(String[] args) {
		
		int[] inputValue = new int[3];
	    Scanner scanner =new Scanner(System.in);
	    int tot = 0; // 합계 구하기
	    double avg = 0; // 평균구하기
		
		//사용자로 부터 정보 입력 받아서 배열에 넣기
		System.out.println("계산할 숫자 " +inputValue.length+ "넣으세요");
		
		for(int i=0; i<inputValue.length; i++) {
			
			inputValue[i] = scanner.nextInt();
		}	
		
		
		//입력한 정보의 합계 구하기
		for(int i=0; i<inputValue.length; i++) {
			tot+=inputValue[i]; 
		}
		
		//입력한 정보의 평균 구하기
		
		avg = (double)tot/inputValue.length;
		
		//입력한 정보출력하기
		System.out.println("귀하가 입력한 정보는 다음과 같습니다.");
		System.out.println("----------------------------");
		
		for(int i = 0; i<inputValue.length; i++) {
			System.out.print(inputValue[i] + "\t");
		
		}
		System.out.println();
		System.out.println("입력한 정보의 총합은 " +tot+ "입니다.");	
		System.out.println("입력한 정보의 평균은 " + String.format("%f",avg) + "입니다.");	
		
	}

}
