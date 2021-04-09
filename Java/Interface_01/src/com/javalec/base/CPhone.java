package com.javalec.base;

public class CPhone implements SmartPhone {

	@Override
	public void callSenderReceiver() {
		System.out.println("C phone : Possible");

	}

	@Override
	public void telMethod() {
		System.out.println("C phone : 4G");

	}

	@Override
	public void tvRemoteController() {
		System.out.println("C phone : Not Applied");


	}

}
