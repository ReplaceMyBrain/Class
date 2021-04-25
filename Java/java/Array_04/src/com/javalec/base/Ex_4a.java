package com.javalec.base;

import java.util.Scanner;

public class Ex_4a {

	public static void main(String[] args) {
		//선언자
		Scanner scanner =new Scanner(System.in);
		int[] score = new int[10]; 
		int[] histo = new int[10];
		
		
		//처리
		System.out.println("Input score :");
		
		for(int i=0; i<10; i++) {
			System.out.print((i+1) + "의 score :");
			score[i]=scanner.nextInt();	
			histo[score[i] / 10]++;
		}
		

		//출력
		System.out.println("----------Histogram---------");
		for(int i=(score.length-1); i>=0; i--) {
			System.out.print(String.format("%3d :", i * 10));
			for(int j=1; j<=histo[i]; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}

		
		

