package com.javalec.base;

import java.util.Scanner;

public class Ex_2 {

	public static void main(String[] args) {
		
		//선언
		Scanner scanner=new Scanner(System.in);
		int max=0; 
		int maxIndex=0;
		
		//처리 #입력갯수
		System.out.print("입력할 숫자의 갯수 ? (100개 미만)"); 
		
			int order =scanner.nextInt();
			
			if (order <100) {
				int[] inputNum = new int[order];
			
			//#입력한 숫자
				System.out.println(order+ "개의 숫자를 입력하세요!");
			
				for(int i=0; i<order; i++) {
					inputNum[i]=scanner.nextInt();
				
					if(max<inputNum[i]) {
						max = inputNum[i];
						maxIndex= i+1;
					}
				
				}
			scanner.close();
			
			//출력
			System.out.println("입력한 숫자중 최대값은 " +max+ "이고 " +(maxIndex)+"번째 값 입니다.");	
				
			}else {
			System.out.println("오류입니다.");	
			}
			
			
	}

}
