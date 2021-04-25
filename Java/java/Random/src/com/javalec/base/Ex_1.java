package com.javalec.base;

import java.util.Random;
import java.util.Scanner;

public class Ex_1 {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int i = random.nextInt(3)+1;
		int num = 1;
		int end = 0;
		
		//가위:1 바위:2 보:3 종료:4
	 	
		while(end==0) {
			System.out.println("가위=1 바위=2 보=3 종료=4 입니다 \n가위 바위 보에 해당하는 숫자를 적어주세요");
			num = scanner.nextInt();
			System.out.println(i);
			
			if(num==1) {
				 switch (num-i) {
				 	case -1 : System.out.println("lose");
				 	break;
				 	case -2 : System.out.println("win");
				 	break;
				 	case 0 : System.out.println("tie"); 
				 	break;
				 }	
			 }else if(num==2) {
				 switch (num-i) {
				 	case -1 : System.out.println("lose"); 
				 	break;
				 	case 1 : System.out.println("win"); 
				 	break;
				 	case 0 : System.out.println("tie"); 
				 	break;	 
				 }
			 }else if(num==3) {	 
				 switch (num-i) {
			 		case 2 : System.out.println("lose");
			 		break;
			 		case 1 : System.out.println("win");
			 		break;
			 		case 0 : System.out.println("tie");
			 		break;
				 }
			 }else if(num==4) {
				 end=1;
				 System.out.println("종료되었습니다.");
			 }
		}

	}

}
