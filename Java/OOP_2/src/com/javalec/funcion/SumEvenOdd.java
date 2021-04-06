package com.javalec.funcion;

public class SumEvenOdd {
	
	//	Property (초기값)
	
	
	// 	Constrictor (생성자)
	 public SumEvenOdd() {
		 
	 }
	
	// Method (함수)
	 public int sumCalc(int num1, int num2) {  // 합계구하는 타입과 메소드 이름. 매개변수() //void는 리턴할 필요가없다.
		 int sum = 0;
		 for(int i=num1; i<=num2; i++) {
			 sum+= i;
		 }
		 
		 return sum;
	 }
	 
	public String evenOdd(int num) {
		
		int remainder = num % 2;
		String chk;
		
		if(remainder == 0) chk="짝수";
		else chk="짝수";
		
	return chk;
		
	}	
		
		
//		String evenOdd ="";
//		
//		if(num%2==0) {
//			evenOdd= "짝수";
//		}else {
//			evenOdd = "홀수";
//		}
//		
//		return evenOdd;
	
}

