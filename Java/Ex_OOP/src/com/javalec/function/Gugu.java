package com.javalec.function;

import java.util.Scanner;

public class Gugu {

	
	//Field
	Scanner scanner = new Scanner(System.in);
	public int num;
	
	//Constructor
	public void gugu() {
			
		}
	//Method
	public void guguPrint1() {
		
		System.out.print("구구단을 출력할 숫자를 입력하세요 :");	
		num = scanner.nextInt();
		
		for(int i=1; i<=9; i++) {
			System.out.println(num + "X" + i + "=" + (num*i));
		}
	}
		
	public void guguPrint2() {
			
		System.out.print("구구단을 출력할 숫자를 입력하세요 :");	
		num = scanner.nextInt();
			
		for(int i=1; i<=9; i++) {
			System.out.println(num+"X"+((i%2==0) ? "*":i)+"="+(num*i));	
		}
	}
}
