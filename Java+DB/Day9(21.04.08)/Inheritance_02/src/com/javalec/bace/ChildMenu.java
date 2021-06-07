package com.javalec.bace;

public class ChildMenu extends ParentsMenu {

	//field
	
	//constructor
	public ChildMenu() {
		
	}
	
	
	//method
	public void makeBeefChung() {
		System.out.println("소고기 청국장");
	}

	public void makeHotDoen() {
		System.out.println("얼큰 된장");
	}
	
	@Override // 상위에 있는 메소드를 바꿈.
	public void makeChung() {
		System.out.println("냄새 없는 청국장");
		//super.makeChung();
	}
	

	
}
