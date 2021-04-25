package com.javalec.base;

import java.util.Scanner;

import com.javalec.function.Add;
import com.javalec.function.Div;
import com.javalec.function.Multipl;
import com.javalec.function.Sub;


public class Main {

	public static void main(String[] args) {
		
		//선언자
		Scanner scanner=new Scanner(System.in);
		Add add = new Add();
		Sub sub = new Sub();
		Multipl multipl = new Multipl();
		Div div = new Div();
		
		//처리
		System.out.println("1번 숫자를 입력하세요");
		int num1 = scanner.nextInt();
		System.out.println("2번 숫자를 입력하세요");
		int num2 = scanner.nextInt();
		
		//출력
		add.addPrint(num1,num2);
		sub.subPrint(num1,num2);
		multipl.multiplPrint(num1,num2);
		div.divPrint(num1,num2);
		
		add.num1 = num1;
		add.num2 = num2;

		int resresultAdd = add.addAction();
		System.out.println(resresultAdd);

		
	}

}
