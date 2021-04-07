package com.javalec.base;

public class AddCalc {

	//Field
	
	//constructor
	public AddCalc() {
		
	}
	
	//Method
	public int[] sumCalc(int[] arr) {
//		int tot =0;
		int[] incNum = new int[arr.length];
		for(int i=0; i<arr.length; i++) {
//			 tot += arr[i];
			incNum[i]= arr[i] +1;
		}
//		return tot;
		return incNum;
		
	}
}
