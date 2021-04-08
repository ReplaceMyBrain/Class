package com.javalec.function;

public class DmbCellPhone extends CellPhone {

	//Field
	public int channel;
	
	//constructor
	public DmbCellPhone() {
		// TODO Auto-generated constructor stub
	}

	public DmbCellPhone(String model, String color, int channel) {  // 편하게 하기 위해서 준다. 새롭게 지정.
		super();
		this.model = model;
		this.color =color;
		this.channel = channel;
	}
	
	//Method
	
	public void turnOnDmb() {
		System.out.println("채널" +channel + "번 DMB방 수신을 시작합니다.");
	}
	
	public void changeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel + "번으로 바꿉니다.");
		
	}
	
	public void turnOffDmb( ) {
		System.out.println("DMB방송 수신을 멈춥니다.");
	}
	
	
	
	
	
	
}
