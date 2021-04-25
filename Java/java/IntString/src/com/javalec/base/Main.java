package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
	int num1 = 123;
	String str1 = "12345";
	String str2 = "abcde";
	
	//Inter는 대문자로 꼭 쓰기!
	
	String str3 =Integer.toString(num1); // 문자로 변경
	System.out.println(str3 + str1);
	
	int num2 = Integer.parseInt(str1); // 숫자로 변경
	System.out.println(num1 + Integer.parseInt(str1));


	}

}