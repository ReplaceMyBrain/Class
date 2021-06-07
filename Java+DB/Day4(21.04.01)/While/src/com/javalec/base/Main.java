package com.javalec.base;

public class Main {

	public static void main(String[] args) {

		//1부터 100까지의 합을 구하기
		
//		int tot = 0;
//		
//		for(int i=1; i<=100; i++) {
//			tot+=i; 
//		}

		//while은 변수 설정 x
		
		int i = 1;
		int tot = 0;
		
//		while(i<=100) {
//			tot+=i;
//			i++;
//	    }
//		
//		while(true) {
//			tot+=i;
//			i++;
//			if(i>100) {
//				break;
//			}
//		}
//		
		
		while(true) {
			if(i%2==1) {
				System.out.println(i);				
			}else {
				break;
			}
			i++;

			if(i > 10) {
				break;
			}
			
		}
		
		
		
		System.out.println(tot);
	}

}
