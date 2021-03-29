package com.javalec.base;

public class MainClass {

	public static void main(String[] args) {
		//main은 한곳밖에 없음 모든것의 시작이라고 생각.
		
		//Commen 커멘트기능
		
		/* --------------------------------
		 *  아래의 기능은 화면에 출력하는 기능입니다.
		 * --------------------------------
		 * cmd + d > 삭제
		 * cmd + alt + 화살표 > 복사
		 * alt + 화살표 > 이동
		 * public은 공동으로 쓰는것이라고 생각
		 * syso 또는 Sout System.out.println 단축
		 * ln은 띄어쓰기됨
		 */
		
		// 화면에 문자열 상수 출력 
		System.out.println("------------");	
		System.out.println("HEllo, World!");
		System.out.println("------------");	

		System.out.print("------------");	
		System.out.print("HEllo, World!");
		System.out.print("------------");	
		System.out.println("");	
		
		// 화면에 정수(숫자) 상수 출력
		System.out.println(10);
		System.out.println(10 + 20); // 덧셈
		System.out.println(10 - 20); // 뺄셈
		System.out.println(10 * 10); // 곱셈		
		System.out.println(10 / 20); // 정수라서 안나옴 / 나눗셈
		System.out.println(10.0 / 20.0); // 실수라서 나옴 / 나눗셈
		
		// ()funtion 출력되는것들
		
		// 화면 출력을 예쁘게 하기
		
		System.out.println("a " + "B");
		System.out.println(10 + "+" + 20 + "=" +(10+20));
		System.out.println(10 + "-" + 20 + "=" +(10-20));
		System.out.println(10 + "*" + 20 + "=" +(10*10));
		System.out.println(10.0 + "/" + 20.0 + "=" +(10.0/20.0));
	
	  
	}
}

