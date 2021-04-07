package com.javalec.function;

import java.util.Scanner;

public class Arithmetic {

	//Field
	Scanner scanner = new Scanner(System.in);
	public int num1 = 0;
	public int num2 = 0;
	
	
	//Constructor
	public  void Arithmetic() {
		
	}
	
	//Method
	public void input() {
		System.out.print("첫번째 숫자를 입력하세요 :");
			num1 = scanner.nextInt();
		System.out.print("두번째 숫자를 입력하세요 :");
			num2= scanner.nextInt();
		System.out.println(">>>>>>>결과<<<<<<<");
	}
	
	public void add() {
	System.out.println("덧셈  :" + (num1+num2));
	}
	
	public void sub() {
	System.out.println("뺄셈  :" + (num1-num2));
	}
	
	public void multipl() {
		System.out.println("곱셈  :" + (num1*num2));
	}
	public void div() {
		if(num2==0) System.out.println("나눗셈  :0으로 나눌수 없습니다.");
		else System.out.println("나눗셈  :" + ((double)num1/(double)num2));
	}
		

}
