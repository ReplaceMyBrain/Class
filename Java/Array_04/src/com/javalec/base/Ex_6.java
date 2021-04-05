package com.javalec.base;

import java.util.Scanner;

public class Ex_6 {

	public static void main(String[] args) {
	
	//선언
	Scanner scanner = new Scanner(System.in);	
	int order=0, i=0, search=0, serchIndex=0, data=0; 
	int[] num = new int[100];
	
	//처리
	System.out.print("입력할 숫자의 갯수? :");
		order=scanner.nextInt();
		
		
	System.out.println(order + "개의 숫자를 입력하세요!:");
	for(i=0; i<order; i++) {
		System.out.print((i+1)+"의 숫자 :");
		num[i] = scanner.nextInt();		
	}
	
	System.out.print("검색할 숫자는? :");
		search =scanner.nextInt();
		for(data=0; data<order; data++) {
			if(search == num[data]) {
				serchIndex = data+1;
				System.out.println(search + "의 위치는 " + serchIndex + "번째 입니다.");
				break;
			}
		}
		if(data==order) {
		System.out.println(search + "는 존재하지 않습니다.");
		}
		

	}

}
