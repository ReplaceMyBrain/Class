package com.javalec.function;

public class TwoNumberCalc {

	// Field
	
	// Construct
	public TwoNumberCalc() {
		// TODO Auto-generated constructor stub
	}
	
	// Method
	
	// 덧셈 
	public String addition(String str1, String str2) {
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		return Integer.toString(num1 + num2);
	}
	
	// 뺄셈
	public String subtraction(String str1, String str2) {
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		return Integer.toString(num1 - num2);		
	}
	
	// 곱셈
	public String multiplication(String str1, String str2) {
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		return Integer.toString(num1 * num2);

	}
	
	// 나눗셈
	public String division(String str1, String str2) {
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		String result;
		
		// 나눗셈의 Division by Zero Check
		if((num1 == 0 && num2 == 0) || (num2 == 0)) {
			result = "불가능";			
		}else {
			result = String.format("%.3f", (double)num1/ num2);			
		}
		
		return result;
	}
	

	
}
