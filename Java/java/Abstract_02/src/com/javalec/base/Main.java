package com.javalec.base;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LunchMenu child1 =new Child1(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND) {
		};
		LunchMenu child2 =new Child2(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND) {
		};
		LunchMenu child3 =new Child3(PriceTable.RICE, PriceTable.BULGOGI, PriceTable.BANANA, PriceTable.MILK, PriceTable.ALMOND) {
		};
		
		System.out.println(child1.calc());
		System.out.println(child2.calc());
		System.out.println(child3.calc());
		
		
		
	}
}
