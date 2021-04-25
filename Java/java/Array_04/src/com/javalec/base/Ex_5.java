package com.javalec.base;

import java.util.Scanner;

public class Ex_5 {

	public static void main(String[] args) {
		
	 //선언
	Scanner scanner=new Scanner(System.in);
	int floor=0, count=1, i=0, j=0;
	
	
	System.out.print("몇 단계의 피라미드로 구성할까 ? :");
		floor=scanner.nextInt();
		
	for (i=1; i<=floor; i++) {
		for(j=1; j<=i; j++) {
			System.out.print(count + "\t");
			count++;
		}
	System.out.println();
	}
 
	
	}

}
