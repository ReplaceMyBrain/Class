package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		//1~10까지 합을 구하여 출력하고, 그 합이 짝수 인지 판단...
		
		int i=0;
		int sum=0;
		
		for(i=1; i<=10; i++) {
			sum+=i;
		}
		
		System.out.println(sum + " " + (sum%2==0 ? "짝수": "홀수"));
		
	}

}
