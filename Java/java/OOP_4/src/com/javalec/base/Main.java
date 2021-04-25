package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
		int[] num = {10,20,30,40,50};
		
		AddCalc addCalc = new AddCalc();
		int[] othertNum = addCalc.sumCalc(num);
		
		for(int i=0; i<num.length; i++) {
			System.out.println(othertNum[i]);
		}

	}

}
