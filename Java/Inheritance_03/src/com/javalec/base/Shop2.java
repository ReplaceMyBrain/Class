package com.javalec.base;

public class Shop2 extends Shop1 {

	//field
	
	//constructor
	public Shop2() {
		// TODO Auto-generated constructor stub
	}
	//method
	@Override
	public void orderKim() {
		System.out.println("김치찌개(HQ) : 5,000원");	
	}
	@Override
	public void orderBu() {
		super.orderBu();
	}
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 5,000원");
	}
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 4,000원");
	}
	@Override
	public void orderbab() {
		System.out.println("공기밥 : 무료입니다.");
	}
	public void print2() {
	System.out.println("Shop2---------------");
	orderKim();
	orderBu();
	orderBi();
	orderSoon();
	orderbab();
	}
}
