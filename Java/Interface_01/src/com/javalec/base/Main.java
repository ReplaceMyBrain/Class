package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		
		SmartPhone aPhone = new APhone();
		SmartPhone bPhone = new BPhone();
		SmartPhone cPhone = new CPhone();
		
		SmartPhone[] smartPhones = {aPhone, bPhone, cPhone};
		for(int i=0; i<smartPhones.length; i++) {
			smartPhones[i].callSenderReceiver();
			smartPhones[i].telMethod();
			smartPhones[i].tvRemoteController();
			System.out.println("-------------------");
		}
		
		
	
	}

}
