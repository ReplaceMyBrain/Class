package com.javalec.base;

import java.util.Scanner;

public class Ex_9 {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		String[] deposit = {"입금", "출금", "현황", "종료"};
		int[] money= {0,0,0,0,0};
		int num=0;
		int clientNum =0;
		int inputmoney=0;
		int i=0;
		int end=0;
		
		while (end==0){
			for(i=0; i<4; i++) {
				System.out.println((i+1) + "." + deposit[i]);
			}
			
			System.out.print("번호를 선택하세요!");
				num=scanner.nextInt();
					
			if(num==1 || num==2) { 	//입금
				System.out.print("고객번호 : ");
				clientNum=scanner.nextInt()-1;
				System.out.print("금액 : ");
				inputmoney=scanner.nextInt();
					
				if (num==1) {
						money[clientNum]+=inputmoney;			
				}else if(num==2) { 
					if(inputmoney<=money[clientNum]) {
						money[clientNum]-=inputmoney;
					}else if(inputmoney > money[clientNum]) {
						System.out.println("잔액이 부족합니다");
					}
				}	
					
				System.out.println("결과 : 고객번호 :" + (clientNum+1) + " 잔액 : " + money[clientNum]);
				System.out.println();			
				
			
				}else if(num==3) { // 현황
					System.out.println("\t\t 고객명 \t 잔액");
					System.out.println("\t\t ------ \t ----");
					for(i=0;i<5; i++) {
						System.out.println("\t\t" + (i+1) + "\t\t" + money[i]);
					}
					
				}else if(num==4) { //종료
					end=1;
					System.out.println(">>>> Thank you <<<<");
				}
			}
		}
	}
	
			



