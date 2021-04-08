package com.javalec.base;

public class Shop3 extends Shop2 {

	//field
	
	//constructor
	public Shop3() {
		// TODO Auto-generated constructor stub
	}
	
	//method
	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 6,000원");
}
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 7,000원");
	}
	@Override
	public void orderBi() {
		System.out.println("비빔밥 : 7,000원");
	}
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 6,000원");
	}
	@Override
	public void orderbab() {
		System.out.println("공기밥(HQ) : 1,000원");
	}
	public void print3() {
	System.out.println("Shop3---------------");
	orderKim();
	orderBu();
	orderBi();
	orderSoon();
	orderbab();
	}
}
