package com.javalec.base;

import java.util.Iterator;
import java.util.Scanner;

import javax.swing.RowFilter.ComparisonType;

public class Main {

	public static void main(String[] args) {
//		
//		for(int i=1; i<=9; i++) {
//			for(int dan=2; dan<=9; dan++) {
//				System.out.print(dan + " X " + i + " = " + (dan*1) + "\t");
//			}
//			System.out.println();
//		}
//	-------------------------------------------------------
//		Scanner scanner=new Scanner(System.in);
//		
//		System.out.print("Input your number : ");
//		
//		int k=scanner.nextInt();
//		
//		for(int n=1; n<=9; n++) {
//			for(int i=k; i<=k+3; i++) {
//			System.out.print(i + " X " + n + " = " + (i*n) + "\t");
//			}
//			System.out.println();
//		}
//		-------------------------------------------------------
//		Scanner scanner=new Scanner(System.in);
//		
//		System.out.print("단을 입력하세요 : ");
//		int dan=scanner.nextInt();
//		
//		for(int i=1; i<=9; i++) {
//			System.out.print(dan+ " X " + i + " = " + (dan*i));
//				if(i %3==0)  System.out.println();
//				else System.out.print("\t");	
//		}
//	
//		-------------------------------------------------------		
			
//		for(int i=2; i<=9; i++) {
//			System.out.print(i + "X" + 1 + "=" + (i*1) + "\t");
//			System.out.print(i + "X" + 2 + "=" + (i*2) + "\t");
//			System.out.print(i + "X" + 3 + "=" + (i*3) + "\n");
//		}
//		
		for(int k=2; k<=9; k++) {
			for(int i=1; i<=3; i++) {
				System.out.print(k + "X" + i + "=" + (i*k)+ "\t" );
			}
			System.out.println();
		}
			
	
		
	}
}		
