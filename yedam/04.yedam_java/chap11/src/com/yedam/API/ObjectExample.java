package com.yedam.API;

import java.util.HashMap;

public class ObjectExample {

	public static void main(String[] args) {
		Member member = new Member("123");
		Member member2 = new Member("123");
		Member member3 = new Member("321");
		
		if(member.equals(member2)) {
			System.out.println("동등한 객체");
		} else {
			System.out.println("다른 객체");
		}
		
		if(member.equals(member3)) {
			System.out.println("동등한 객체");
		} else {
			System.out.println("다른 객체");
		}

		HashMap<Key, String> hashmap = new HashMap<>();
		
		hashmap.put(new Key(1), "홍길동");
		
		String value = hashmap.get(new Key(1));
		
		System.out.println(value);
		//hashCode를 오버라이딩 함으로서 key를 값으로 비교할 수있다.
		
		HashMap<Member, String> hashmap01 = new HashMap<>();
		
		hashmap01.put(new Member("123"), "길동");
		
		System.out.println(hashmap01.get(new Member("123")));
		
		Object obj = new Object();
		Object obj2 = new Object();
		
		System.out.println(obj); //java.lang.Object@4926097b
		System.out.println(obj.toString()); //java.lang.Object@4926097b
		
		SmartPhone sp = new SmartPhone("apple", 100, "iphone");
		
		
		System.out.println(sp.toString()); //SmartPhone [company=apple, price=100, name=iphone]
	}
}
