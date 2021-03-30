package com.javalec.base;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		
		Scanner scan =new Scanner(System.in);
		
		System.out.println("국어 점수를 입력하세요!");
		int kor = scan.nextInt();
		System.out.println("영어 점수를 입력하세요!");
		int eng = scan.nextInt();
		System.out.println("수학 점수를 입력하세요!");
		int mat = scan.nextInt();
		
		
		double average = (kor+eng+mat)/3;
		System.out.println("평균점수 : " + average);
		
		System.out.print("국어점수는 평균 ");
	
		if(kor>average) System.out.println("보다 높습니다.");
		else if((double)kor==average) System.out.println("점수입니다.");
		else System.out.println("보다 낮습니다.");
		
		System.out.print("영어점수는 평균 ");
		if(eng>average) System.out.println("보다 높습니다.");
		else if((double)eng==average) System.out.println("점수입니다.");
		else System.out.println("보다 낮습니다.");
		
		System.out.print("수학점수는 평균 ");
		if(mat>average) System.out.println("보다 높습니다.");
		else if((double)mat==average) System.out.println("점수입니다.");
		else System.out.println("보다 낮습니다.");
	
	}

}
