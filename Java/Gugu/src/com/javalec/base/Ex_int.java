package com.javalec.base;

import java.util.Iterator;
import java.util.Scanner;

public class Ex_int {

	public static void main(String[] args) {
	
		//ex
		//enter an integer(0~9) : 
		//Sum of digits =
	
		//선언
		Scanner scanner =new Scanner(System.in);
		int sum=0;
		
		//처리
		System.out.print("enter an integer(0~9) :");
		
		for(int num = scanner.nextInt(); num>0; num/=10) {
			sum += num%10;
		}
	
		//결과
		System.out.println("Sum of digits =" + sum);
		
	
		
	}

}
