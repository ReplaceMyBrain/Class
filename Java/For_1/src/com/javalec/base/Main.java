package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
//		Scanner scanner =new Scanner(System.in);
//		
//		System.out.print("단을 입력하세요 :");
//		int dan = scanner.nextInt();
//		int dan =0;
		
		for(int dan=2; dan<=9; dan++) {
			System.out.println("--------" +dan+ "단------------");
			for(int i=1; i<=9; i++) {
				System.out.println(dan + " X " + i + " = " + String.format("%2d",(dan*i)));
			}
			
		}
		
//		for(int i=1; i<=9; i++) {
//			//System.out.println(i); //체크해보는것
//			System.out.println(dan + " X " + i + " = " + String.format("%2d",(dan*i)));
			
			//string.format 찾아보기
			//하나씩 추가해보는것
			
			

	}

}
