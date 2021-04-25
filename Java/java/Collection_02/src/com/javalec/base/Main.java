package com.javalec.base;

import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
	HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
	hashMap.put(10, "str0");
	hashMap.put(11, "str1");
	hashMap.put(21, "str2");
	hashMap.put(31, "str3");
	
	System.out.println(hashMap);
	System.out.println(hashMap.get(11));
	
	HashMap<String, String> hashMap2 = new HashMap<String, String>();
	hashMap2.put("a", "apple");
	hashMap2.put("b", "banana");
	hashMap2.put("c", "coke");
	System.out.println(hashMap2);
	System.out.println(hashMap2.get("c"));
	
	hashMap2.remove("a");
	System.out.println(hashMap2);
	
	hashMap2.clear();
	
	
	}

}
