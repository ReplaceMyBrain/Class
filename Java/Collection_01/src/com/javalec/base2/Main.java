package com.javalec.base2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Student> arrayList = new ArrayList<Student>();
		arrayList.add(new Student("james",100));
		arrayList.add(new Student("Roberts",90));
		arrayList.add(new Student("Cathy",95));
		
		for(int i=0; i < arrayList.size(); i++) {
			System.out.print(arrayList.get(i).getName()+"\t\t");
			System.out.println(arrayList.get(i).getScore());
		}

	}

}
