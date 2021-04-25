package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String str1 = "abcdefg";
		String str2 = "HIJKLMN";
		String str3 = "opqrstu";
		String str4 = " abc def ghi ";
		
		System.out.println(str1.concat(str2)); 		//문자열 연결시켜줌
		System.out.println(str1.substring(3));  	//3까지 빼기
		System.out.println(str1.substring(3,5));	//3까지 5부빼기
		System.out.println(str1.length()); 			//길이
		System.out.println(str1.toUpperCase()); 	//대문자로 변경
		System.out.println(str2.toLowerCase());		//소문자로 변경
		System.out.println(str1.charAt(2)); 		//이 다음 번째만 나옴
		
		System.out.println("------------------");
		//str1을 알파벳 하나씩 출력하기
		for(int i=0; i<str1.length(); i++) {
			System.out.println(str1.charAt(i));
		}
		
		System.out.println("------------------");
		
		System.out.println(str1.indexOf('c')); 		// c는 n번째 다음에 있다
		System.out.println(str1.equals(str3)); 		// 같냐
		System.out.println(str4.trim()); 			// 앞뒤 스페이스 공백없애기 로그인에 쓰임.
		System.out.println(str1.replace('a', 'z')); // 앞을 뒤에껄로 바꾸다.
		System.out.println(str1);
		System.out.println(str1.replaceAll("abc", "zzzzzzzz"));
		 
		
		System.out.println("------------------");

		
//		String str1 = new String("Hello");
//		
//		Scanner scanner = new Scanner(System.in);
//		scanner.n`

	}

}
