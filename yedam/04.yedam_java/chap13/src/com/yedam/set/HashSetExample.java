package com.yedam.set;

import java.util.*;

public class HashSetExample {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("JDBC");
		set.add("Servelt/JSP");
		set.add("Java");
		set.add("iBatis");
		
		//size
		int size = set.size();
		System.out.println("총 객체 수 : " + size); // set은 중복을 허용하지 않는다.
		
		//반복자 활용한 HashSet 객체 출력
		Iterator<String> iterator = set.iterator();
		
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		
		set.remove("Java");
		set.remove("JDBC");
		
		System.out.println("===== 향상된 for 문 =====");
		
		for(String temp : set) {
			System.out.println("\t" + temp);
		}
		
		set.clear();
		
		System.out.println("총 객체 수 : " + set.size());
		
		if(set.isEmpty()) {
			System.out.println("객체가 하나도 없습니다.");
		}
		
		Set<Member> mSet = new HashSet<>();
		
		mSet.add(new Member("고길동", 20));
		mSet.add(new Member("고길동", 20));
		
		System.out.println("총 객체 수 : " + mSet.size()); // 1개 
	}

}
