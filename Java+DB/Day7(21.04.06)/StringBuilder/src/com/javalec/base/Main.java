package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		// String의 문제점을 해결하기 위해 나온 문자열 선언자들
		String string = new String("abcdef");
	
		StringBuilder stringBuilder = new StringBuilder("abcdef");
		stringBuilder.append("hijklmn"); 							//덧붙임
		System.out.println(stringBuilder);							//바로 적용됨.
		
		stringBuilder.insert(3, "zzz");								//3이후 삽입
		System.out.println(stringBuilder);					
		
		stringBuilder.delete(3,6);									//삭제
		System.out.println(stringBuilder);

		System.out.println("--------------------------");
		
		StringBuffer stringBuffer = new StringBuffer("abcdef");		//builde가 더 빠름.
		stringBuffer.append("hijklmn"); 							//덧붙임
		System.out.println(stringBuffer);							//바로 적용됨.
		
		stringBuffer.insert(3, "zzz");								//3이후 삽입
		System.out.println(stringBuffer);							
		
		stringBuffer.delete(3,6);									//삭제
		System.out.println(stringBuffer);

	}

}
