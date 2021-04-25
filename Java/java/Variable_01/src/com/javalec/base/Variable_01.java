package com.javalec.base;

public class Variable_01 {

	public static void main(String[] args) {
		// 변수(Variable)
		// 문자열 변수 선언
		String str = "Hello, World!"; // 변수 선언
		// string은 문자이고 꼭 대문자사용 / 클라스형 타입 - 대문
		//  "=" > 할당연산자라고함.
		// string 처음만들때만 사용
		
		System.out.println(str);
		System.out.println(str);

		str= "abc";
		System.out.println(str);
				
		//정수 변수 선언 / 선언은 가장 위에 있는 것이 가장 좋다!
		
		//선언
		int num1 = 10;
		int num2 = 20;
		int plusResult; // camel 기법 이라고함 소문자에서 새로운 단어가 나오면 대문자를 사용한다.
		
		//계산
		plusResult = num1 + num2;
		
		//출력
		System.out.println(num1 + num2); 
		System.out.println(num1 - num2); 
		System.out.println(num1 * num2); 
		System.out.println(num1 / num2); // 실수라서 불가
		System.out.println((double)num1 / num2); // 하나만 실수로 바꿔도 된다. > 이게 정답 또는 두 숫자에 모두 적용
		//System.out.println((double) (num1 / num2); // 바꾼걸 바꾸면 문제가 되는것. 변환 의미없음.
		System.out.println(plusResult); 
		
		
		num1 = 100; // 10에서 100으로 바꿈 순서대로 진행됨.
	    // num1 = "abc"; // 불가능
		
		// ------Exercise
		int startNum = 50, endNum = 60;
		int plusResult2;
	    int subResult;
	    int multiplResult;
	    int divResult;
	    double divresultdouble;
	    
		
	    plusResult2 = startNum + endNum;
		subResult = startNum - endNum;
		multiplResult = startNum * endNum;
		divResult = startNum / endNum;
		divresultdouble = (double)startNum / endNum;
		
	   
		/* 
		 * 30과 40의 덧셈 결과는 70 입니다.
		 * 30과 40의 뺄셈 결과는 -10 입니다.
		 * 30과 40의 곱셈 결과는 1200 입니다.
		 * 30과 40의 나눗셈 중 몫은 0 입니다.
		 * 30과 40의 나눗셈 결과는 0.75 입니다.
		 * 30과 40의 덧셈결과와 뺄셈 결과의 곱은 -700 입니다.
		 */
		
		
		
		System.out.println(startNum + "과 " + endNum + "의 덧셈결과는 " + (plusResult2) + " 입니다");
		System.out.println(startNum + "과 " + endNum + "의 뺄셈결과는 " + (subResult) + " 입니다");
		System.out.println(startNum + "과 " + endNum + "의 곱셈결과는 " + (multiplResult) + " 입니다");
		System.out.println(startNum + "과 " + endNum + "의 나눗셈 중 몫은 " + (divResult) + " 입니다");
		System.out.println(startNum + "과 " + endNum + "의 나눗셈 결과는 " + (divresultdouble) + " 입니다");
		System.out.println(startNum + "과 " + endNum + "의 덧셈결과와 뺄셈 결과의 곱은 " + (plusResult2 * subResult) + " 입니다");
		
		
		
	}

}
