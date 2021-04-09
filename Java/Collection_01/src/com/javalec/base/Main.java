package com.javalec.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
	
	//ArrayList
	ArrayList<String> arrayList = new ArrayList<String>();
	
	System.out.println("<<<ArrayList>>>");
	
	//ArratList에 Data추가
	arrayList.add("str1");
	arrayList.add("str2");
	arrayList.add("str3");
	arrayList.add("str4");
	System.out.println(arrayList);

	//ArrayList의 Data 불러오기
	String str1 = arrayList.get(3);
	System.out.println("index 3:" + str1);
	
	//ArrayList의 특정 index의 data를 수정하기
	arrayList.set(1, "str2222");
	System.out.println(arrayList);
	
	// ArrayList의 크기 확인하기
	int size = arrayList.size();
	System.out.println("size : " + size);
	
	// ArrayList의 내용 삭제하기
	arrayList.remove(1); //번지수로 지우기
	System.out.println(arrayList);
	
	arrayList.remove("str4"); //이름으로 지우기
	System.out.println(arrayList);
	
	//ArrayList의 내용 전체 초기화 하기
	arrayList.clear();
	System.out.println(arrayList);
	
	
	//CRUD 크루드! C=create /R=Read /U=Update /D=Delete 중요하다!!!! 
	
	//Linked List
	LinkedList<String> linkedList = new LinkedList<String>();
	System.out.println(">>>Linked List<<<");
	
	//LinkedList에 Data추가
	linkedList.add("str1");
	linkedList.add("str2");
	linkedList.add("str3");
	linkedList.add("str4");
	
	//LinkedList의 Data 불러오기
	String str11 = linkedList.get(3);
	System.out.println("index 3:" + str11);
	
	//LinkedList의 특정 index의 data를 수정하기
	linkedList.set(1, "str2222");
	System.out.println(linkedList);
	
	// LinkedList의 크기 확인하기
	int size1 = linkedList.size();
	System.out.println("size : " + size);
	
	// LinkedList의 내용 삭제하기
	linkedList.remove(1); //번지수로 지우기
	System.out.println(linkedList);
	
	linkedList.remove("str4"); //이름으로 지우기
	System.out.println(linkedList);
	
	//LinkedList의 내용 전체 초기화 하기
	linkedList.clear();
	System.out.println(linkedList);
	
	//Vectot
	Vector<String> vecotrStrings = new Vector<String>();
	
	//다 똑같다.
	
	
	
	}

}
