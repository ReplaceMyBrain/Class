package com.javalec.function;

public class AddNum {

	//Field 전역변수
 	public int num1, num2;
	
	
	//Constructor
	public AddNum() {
	
	}

	//똑같아도 쓸수있다. 이것을 오버로딩이라고 한다.
	public AddNum(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}


	//Method
	public int addAction(int i, int j) {
		int addResult = i+j;
		return addResult;
	}
	
	public void addPrint(int i, int j) {
		System.out.println(i+j);
		
	}
	
	public int addAction2() {
		return num1+num2;
	}
		

	
	
}
