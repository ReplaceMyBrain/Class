package com.javalec.variable_03;

public class MainClass {

	public static void main(String[] args) {
		// 연산자 종류별 출력
		int i = 10;
		int j = 2, k = 5;
		
		System.out.println("<-- 산술연산자 -->");
		System.out.println("덧셈:" + i + " + " + j + " = " + (i+j));
		System.out.println("뺄셈:" + i + " - " + j + " = " + (i-j));
		System.out.println("곱셈:" + i + " * " + j + " = " + (i*j));
		System.out.println("나눈 몫:" + i + " / " + j + " = " + (i/j));
		System.out.println("나눈 나머지:" + i + " % " + j + " = " + (i%j));
		// 나머지기호 %값 많이씀! 짝수 홀수로 처리시
		
		System.out.println("<-- 자동 증감 연산자 -->");
//		i = i+1;
//		i += 1; 
		i++;
		System.out.println(i);
		
//		j = j - 1;
//		j -= 1;
		j--;
		System.out.println(j);
		
		// 필수! if - 가정 / for - 반복 
		
		System.out.println("<-- 동등 비교 관계 연산자 -->");
		System.out.println("i == j :" + (i == j)); // 같은것은 == 두번쓴다!
		System.out.println("i != j :" + (i != j)); // 같은 않은것은 !=
		System.out.println("i > j  :" + (i > j));
		System.out.println("i < j  :" + (i < j));
		System.out.println("i >= j  :" + (i >= j));
		System.out.println("i <= j  :" + (i <= j));
		
		System.out.println("<-- 논리 연산자 -->"); // 집합 교집합 또는 합집합
		System.out.println((i > j) && (j > k)); // && and조건 교집합
		System.out.println((i > j) || (j > k)); // || or조건 합집합
		
		System.out.println("<-- 삼항 연산자 -->");
		System.out.println(k==5 ? "k는 5" : "k는 5아님"); // k가 5 /T면 전자 F면 후자
		
		//Exercise i가 홀수 인지 짝수 인지 출력하시오
		
		System.out.println(i);
		System.out.println(i%2==0 ? "i는 짝수" : "i는 홀수");
		System.out.println(i%2==1 ? "i는 홀수" : "i는 짝수");
		
		
		
		
		
		
		
		
	}

}
