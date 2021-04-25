package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		
		//name 보다 Index 값을 사용하는 것이 좋다. 카멜 방식으로 사용하 
		//선언
		String[] name = {"james", "Cathy", "kenny", "Martin", "crystal"};
		Scanner scanner = new Scanner(System.in);
		int[] height =new int[name.length];
		
		int tot = 0;	//합계
		double avg = 0; //평균
		int max = 0;	//최대값
		int min = 1000; //최소값 *최소값을 구할땐 최대값부터 시작하는 방법
		String maxname =""; // 최대값의 이름
		String minname =""; // 최소값의 이름
		
		//처리
		for(int i=0; i<name.length; i++) {
			
			System.out.print(name[i]+"의 신장을 입력하세요!");
			height[i] = scanner.nextInt(); 
			
				if (max<height[i]) {//최대값구하기
					max = height[i]; 
					maxname = name[i];
				}
				if (min>height[i]) {//최소값 구하기
					min = height[i];	
					minname = name[i];
				}
			
	   
			tot+= height[i];  						//입력한 정보의 합계 구하기
		}
			avg = (double)tot/name.length; 			//입력한 정보의 평균 구하기
	
		//출력
		System.out.println("평균신장은: " + avg);
		System.out.println("가장 큰 학생은 " +maxname+ " 이고 그 학생의 키는 " +max);
		System.out.println("가장 작은 학생은 " +minname+ " 이고 그 학생의 키는 " +min);

	}

}
