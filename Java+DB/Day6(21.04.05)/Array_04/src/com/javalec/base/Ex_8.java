package com.javalec.base;
import java.util.Scanner;

public class Ex_8 {

	public static void main(String[] args) {
		
		//선언
		Scanner scanner = new Scanner(System.in);
		int count=0, i=0, del=0;
		int[] num = new int[100];
		
		//처리
		
		//갯수 입력
		System.out.print("입력할 숫자의 갯수? ");
		count=scanner.nextInt();
		
		
		//갯수의 수만큼 숫자 입력
		System.out.println(count+"개의 숫자를 입력하세요!:");
		for(i=0; i<count; i++) {
			System.out.print((i+1)+"의 숫자 :");
			num[i]=scanner.nextInt();
		}
		
		//삭제할 순번
		System.out.print("몇번째의 숫자를 삭제 하시겠습니까?");
			del=scanner.nextInt()-1;
		for(i=del; i<count-1; i++) {
			num[i]=num[i+1];
		}
		
		//출력
		System.out.println("----결과-----");
		for(i=0; i<count-1; i++) {
			System.out.println(num[i]);
		}
	

	}
}