package com.javalec.base;

public class BPhone implements SmartPhone {

	@Override
	public void callSenderReceiver() {
		System.out.println("B phone : Possible");

	}

	@Override
	public void telMethod() {
		System.out.println("B phone : 4G");

	}

	@Override
	public void tvRemoteController() {
		System.out.println("B phone : Applied");


	}

}
