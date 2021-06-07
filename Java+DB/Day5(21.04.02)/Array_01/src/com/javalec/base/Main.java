package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		//초기값이 없는 배열 선언 및 데이터 추가하
		
//		String[] str= new String[7];
//		
//		str[0] = "일요일";
//		str[1] = "월요일";
//		str[2] = "화요일";
//		str[3] = "수요일";
//		str[4] = "목요일";
//		str[5] = "금요일";	
//		str[6] = "토요일";

		//초기값이 있는 경우
		String[] str = {"일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"};
		
		System.out.println(str);
		System.out.println(str[0]);
		System.out.println(str[1] + "," + str[3] + "," + str[5]);
		
		for(int i=0; i<str.length; i++) {
			System.out.println(str[i]);
			
		}
		
	}

}
