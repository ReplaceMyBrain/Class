package com.javalec.function;

import javax.swing.JOptionPane;

public class Calc {

	// Field
	
	// Construct
	public Calc() {
		// TODO Auto-generated constructor stub
	}
	
	// Method
	public String add(String a, String b) { 
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
	   
		return Integer.toString(num1 + num2);
	}
	public String sub(String a, String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);	
		return Integer.toString(num1 - num2);
	}
	public String mul(String a, String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		return Integer.toString(num1 * num2);
	}
	public String div(String a, String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		String result;
		
		//div 0오류 처리
		if(num2 ==0) {
			result = "NO";
		}else {
			result = String.format("%3f",(double)num1/num2);
			//Integer.toString을 안써도 문자로 변경되는 것인가
		}
		return result;		
	}
	

	
}
