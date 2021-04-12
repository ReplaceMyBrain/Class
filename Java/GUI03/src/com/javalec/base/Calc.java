package com.javalec.base;

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
	   
		return a + "+"+ b + "=" + Integer.toString(num1+num2) ;
	}
	public String sub(String a, String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		return a + "-"+ b + "=" + Integer.toString(num1-num2);
	}
	public String mul(String a, String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		return a + "x"+ b + "=" + Integer.toString(num1*num2);
	}
	public String div(String a, String b) {
		int num1 = Integer.parseInt(a);
		int num2 = Integer.parseInt(b);
		String result;
		
		//div 0오류 처리
		if(num2 ==0) {
			result = "0 is not Div";
		}else {
			result = a + "%"+ b + "=" + String.format("%3f",(double)num1/num2);

		}
		return result;			
	}
	
	
	


	
}
