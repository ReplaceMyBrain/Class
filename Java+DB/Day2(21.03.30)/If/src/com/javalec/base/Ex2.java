package com.javalec.base;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/* BMI지수= 몸무게(kg) ÷ (신장(m) × 신장(m))이다
		 *  18.5 이하면 저체중 
		 *  18.5~23은 정상 
		 *  23~25는 과체중 
		 *  25~30은 비만
		 *  30이상은 고도비만으로 나누어진다.
		 */
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("BMI측정을 해보겠습니다.");
		System.out.println("몸무게(kg)을 입력해주세요.");
		double kg = sc.nextInt();
		System.out.println("신장(cm)를 입력해주세요.");
		double cm = sc.nextInt();
		
		double m = cm/100;
		double bmi= kg/(m*m);
		
		if (bmi<=18.5) System.out.print("저체중");
		else if (bmi<=23) System.out.print("정상");
		else if (bmi<=25) System.out.print("과체중");
		else if (bmi<=30) System.out.print("비만");
		else System.out.print("고도비만");
		
		System.out.println("입니다");
		
				
			

		
		
	}

}
