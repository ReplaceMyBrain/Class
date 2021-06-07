package com.javalec.base;

import java.util.Scanner;

public class Ex_4 {

	public static void main(String[] args) {
		
		//선언
		Scanner scanner=new Scanner(System.in);
		int[] inputScore = new int[10];
		
		//처리
		
		System.out.println("Input score :");
		
		for(int i=0; i<10; i++) {
			System.out.print((i+1)+"의 score :");
			inputScore[i]=scanner.nextInt();	// 점수 입력 및 범위설정
		}
		
		
		//출력
		System.out.println("----------Histogram---------");
		for (int i=9; i>=0; i--) { 								// 90부터 내림차순 표시
			System.out.print(String.format("%2d", i*10) + " : ");
			for (int j=0; j<10; j++) { 							// 표시할 #의 범위지정
				if(inputScore[j]>=(i*10) && inputScore[j]<(i+1)*10) {
					System.out.print("#");
				}
			}
		System.out.println();	
		}

	}

}
