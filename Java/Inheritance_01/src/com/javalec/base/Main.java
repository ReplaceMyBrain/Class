package com.javalec.base;

import com.javalec.function.DmbCellPhone;

public class Main {

	public static void main(String[] args) {
		
		//DmbCellPhone의 Instance를 생성.
		
		//선언자
		DmbCellPhone dmbCellPhone =new DmbCellPhone("자바폰","검정",10);
		
		
		//처리
	
		//출력
		
		System.out.println("모델:"+dmbCellPhone.model);
		System.out.println("색상:"+dmbCellPhone.color);
		System.out.println("채널:"+dmbCellPhone.channel);
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요.");
		dmbCellPhone.sendVoice("여보세요");		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
	}

}
