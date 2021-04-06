package com.javalec.base;

import com.javalec.funcion.SumEvenOdd;
import com.javalec.funcion.SumEvenOdd2;

public class Main {

	public static void main(String[] args) {
		
		SumEvenOdd sumEvenOdd = new SumEvenOdd(); //new는 복제본이라고 생각하면 쉽다.new 없으면 한사람밖에 사용불가.
	int i=1, j=7;
	
	
//	int sum = sumEvenOdd.sumCalc(i, j);
//	String chk = sumEvenOdd.evenOdd(sum);
//	
//	System.out.println(i + " ~ " + j + " 의 합은 " + sum + "입니다.");
//	System.out.println(chk + "입니다.");
//	

	SumEvenOdd2 sumEvenOdd2 = new SumEvenOdd2();
	sumEvenOdd2.sumCalc(i, j);
	sumEvenOdd2.evenOdd();
	}

}
