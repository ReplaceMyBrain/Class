package com.javalec.base;

public class StoreHQ {

	//field
	
	//constructor
	public StoreHQ() {
		// TODO Auto-generated constructor stub
	}
	
	//method
	
	public void orderKim() {
		System.out.println("김치찌개(HQ) : 5,000원");
	}
	public void orderBu() {
		System.out.println("부대찌개(HQ) : 6,000원");
	}
	public void orderBi() {
		System.out.println("비빔밥(HQ) : 6,000원");
	}
	public void orderSoon() {
		System.out.println("순대국(HQ) : 5,000원");
	}
	public void orderbab() {
		System.out.println("공기밥(HQ) : 1,000원");
	}
	public void print() {
	System.out.println("HQ---------------");
	orderKim();
	orderBu();
	orderBi();
	orderSoon();
	orderbab();
	}
}
