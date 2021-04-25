package com.javalec.base;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		//Random
		
//		for(int i=1; i<=6; i++) {
//			
//			double d = Math.random();
//			int a = (int)(d*3) +1;
//			System.out.println(a);
//		}
//		
		Random random = new Random();
		int i = random.nextInt(3);
		System.out.println(i+1);
				
		//Class는 대문자로 시작한다! 꼭 알아둘것
	}

}
