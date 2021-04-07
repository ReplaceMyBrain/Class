package com.javalec.function;
import java.util.Scanner;

public class Sum {

	//Field
	Scanner scanner = new Scanner(System.in);
	public int sum=0;
	//Constructor
	public void Sum() {
			
	}
	//Method
	public void sumPrint1() {
		
		
		System.out.print("Enter an integer(0~9)");
		
		for(int i =scanner.nextInt(); i!=0; i/=10) {
			sum+=(i%10);
		}

		System.out.println(sum);
	}
	public void sumPrint2() {
		
		
		System.out.print("Enter an integer(0~9)");
		String num = scanner.next();
		
		for(int i=0; i<num.length(); i++) {
		 sum+= num.charAt(i)-'0';			
		}
		
		System.out.println(sum);
	}
}
