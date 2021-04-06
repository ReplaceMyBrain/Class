package com.javalec.funcion;

public class SumEvenOdd2 {
	
	//	Property (초기값)
	int num=0;
	
	// 	Constrictor (생성자)
	 public SumEvenOdd2() {
		 
	 }
	
	// Method (함수)
	 public void sumCalc(int num1, int num2) {  // 합계구하는 타입과 메소드 이름. 매개변수() //void는 리턴할 필요가없다.
		 int sum = 0;
		 for(int i=num1; i<=num2; i++) {
			 sum+= i;
		 }
		 num = sum;
		 System.out.println(num1 + " ~ " + num2 + " 의 합은 " + sum + "입니다.");
		 	 
	 }
	 
	public void evenOdd() {
		
		int remainder = num % 2;
		String chk;
		
		if(remainder == 0) chk="짝수";
		else chk="홀수";
		
		System.out.println(chk+"입니다.");
		
	}	
}
