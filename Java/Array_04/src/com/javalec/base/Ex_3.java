package com.javalec.base;

import java.util.Scanner;

public class Ex_3 {

	public static void main(String[] args) {
		
	Scanner scanner=new Scanner(System.in);
	String[] subject = {"Korean","English","Mathematics","Total", "Average"};
	int kor[] = new int[subject.length];
	int eng[] = new int[subject.length];
	int mat[] = new int[subject.length];
	int total[]  = new int[subject.length];
	int avg[] = new int[subject.length];
	int sum = 0;
	int avg1 = 0;
	
	for(int i=0; i<3; i++) {
		System.out.println(subject[i]+ "의 성적을 입력 :");
		for(int k=0; k<4; k++) {
			if (i==0) {
				System.out.println("NO" +(k+1)+"의 성적은 :");
			   kor[k]=scanner.nextInt();	
			 }
			else if (i==1) {
				System.out.println("NO" +(k+1)+"의 성적은 :");
				eng[k]=scanner.nextInt();	
			}
			else {
				System.out.println("NO" +(k+1)+"의 성적은 :");
				mat[k]=scanner.nextInt();	
			}		
		 total[k] = kor[k]+eng[k]+mat[k];
		 avg[k] = total[k]/(i+1);
		 
		}
	}
	for(int i=0; i<subject.length; i++) {
	System.out.print("\t\t" + subject[i]);
	}
	System.out.println();
	for(int k=0; k<4; k++) {
	System.out.println("no" + (k+1) + "\t\t" + kor[k] + "\t\t" + eng[k] + "\t\t" + mat[k] + "\t\t\t" + total[k] + "\t\t" + avg[k]);
	}
	
	
	
	}
}
	
		
//		Scanner scanner=new Scanner(System.in);
//		String[] name = {"No1","No2","No3","No4"};
//		String[] subject = {"Korean","English","Mathematics","Total", "Average"};
//		int[] avg=new int[name.length];
//		int[] total=new int[name.length];
//		int[] scoreInput =new int[name.length];
//		
//		
//		for(int i=0; i<(subject.length-2); i++) {
//			System.out.println(subject[i]+ "의 성적을 입력 :");
//			for(int k=0; k<name.length; k++) {
//				System.out.print(name[k]+"의 성적은 :");
//				scoreInput[i] = scanner.nextInt();
//			}
//		  	
//		}
//		
//		for(int i=0; i<subject.length; i++) {
//		System.out.print("\t\t" + subject[i]);
//		}
//		
////		for(int k=0; k<name.length; k++) {
////		System.out.print(scoreInput[k] + "\t");
////		System.out.println();
////		}
