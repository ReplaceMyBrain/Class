package com.javalec.base;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
//		for(int i=1; i<=10; i++) {
//		System.out.println(i);
//		}

//		//1부터 10까지 합계 구하기
//		
//		int tot=0; // 누적변
//		for(int i=1; i<=10; i++) {
//			tot = tot+i;	
//		}
//		System.out.println("1부터 10까지 합은 " + tot + "입니다.");

		
		
//		//Exercise
//		//1부터 100까지의 수중 짝수의 합과 홀수의 합을 구하시오 (단, if문 사용)
//		
//		//선언
//		int toteven = 0, totodd =0;
//		
//		//처리
//		for(int i=1; i<=100; i++) {
//			if(i%2 == 0) {													//짝수 
//				toteven += i;												//짝수의 합
//			}else {															//홀수
//				totodd +=i;													//홀수의 합 
//			}
//		}	
//		
//		//결과
//		System.out.println("짝수의 합은" + toteven + "이고 홀수의 합" + totodd + "이다");
		
		
		
//		// 1부터 100까지의 수중 짝수의 합 구하기 (단, if문 사용하지 말기)
//		
//		int toteven = 0;
//		for(int i=2; i<=100; i += 2) {
//		 toteven += i;
//		}
//		
//		System.out.println(toteven);
		
		
		
//		Scanner scanner =new Scanner(System.in);
//		int tot = 1;
//		
//		System.out.print("Input your decimal no. : ");
//		int num = scanner.nextInt();
//		
//		for(int i=1; i<=num; i++) {
//			tot=tot*i;
//		}
//		
//		System.out.println(num + "'s factorial value = " + tot);
		
		
		Scanner scanner =new Scanner(System.in);
		int tot = 1;
		
		System.out.print("Input your decimal no. : ");
		int num = scanner.nextInt();
		
		for(int i=num;i>=1; i--) {
			tot=tot*i;
		}
		
		System.out.println(num + "'s factorial value = " + tot);
		
		
	}

}

