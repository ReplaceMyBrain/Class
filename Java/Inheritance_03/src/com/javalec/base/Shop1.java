package com.javalec.base;

public class Shop1 extends StoreHQ{

	//field
	
	//constructor
	public Shop1() {
		// TODO Auto-generated constructor stub
	}
	//method
	@Override
	public void orderKim() {
		System.out.println("김치찌개 : 4,500원");
}
	@Override
	public void orderBu() {
		System.out.println("부대찌개 : 5,000원");
	}
	@Override
	public void orderBi() {
		super.orderBi();
	}
	@Override
	public void orderSoon() {
		System.out.println("순대국 : 판매하지 않습니다.");
	}
	@Override
	public void orderbab() {
		super.orderbab();
}

	public void print1() {
		System.out.println("Shop1---------------");
		orderKim();
		orderBu();
		orderBi();
		orderSoon();
		orderbab();
		
	}
}
