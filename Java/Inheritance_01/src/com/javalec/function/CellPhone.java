package com.javalec.function;

public class CellPhone {

	//Field
	public String model;
	public String color;
	
	
	
	//Constructor
	public CellPhone() {
		
	}
	
	//Method
	public void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	public void powerOff() {
		System.out.println("전원을 끕니다.");
	}
	public void bell() {
		System.out.println("벨이 울립니다.");
	}
	public void sendVoice(String message) {
		System.out.println("본인 : " + message);
	}
	public void receiveVoice(String message) {
		System.out.println("상대방 : " + message);
	}
	public void hangUp() {
		
	}
	
}
