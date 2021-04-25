package com.javalec.base;

import java.util.ArrayList;

public class Ex_01 {

	public static void main(String[] args) {
	
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int sum = 0;
		
		
			for(int i=0; i<=100;  i+=2){
				arrayList.add(i);
			}
			for(int i=0; i<arrayList.size(); i++) {
				sum+=arrayList.get(i);
			}
		
		System.out.println(sum);
			

	}

}
