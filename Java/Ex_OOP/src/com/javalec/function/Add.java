package com.javalec.function;

public class Add {

	//Field
	public int num1, num2;
	//Constructor
	public Add() {
		
	}
	//Method
	public void addPrint(int i, int j) {
		System.out.println("덧셈값은 " + (i+j));
	}
	
	public int addAction() {
		return num1+num2;
	}
	
	
}


