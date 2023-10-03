package com.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

	public static void main(String[] args) {
		//String 문자열을 담을 수 있는 list
		List<String> list = new ArrayList<String>();
		
		//리스트 데이터 추가
		list.add("Java");
		list.add("JDBC");
		list.add("Servelt/Jsp");
		//인덱스 2 데이터 추가
		list.add(2, "DataBase");
		list.add("iBatis");
		
		//size() -> 배열.length()
		//LIST의 크기는 가변적이다. ( 배열과 다름 )
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
		for(String data : list) {
			System.out.println(data);
		}
		
		System.out.println("========================================");
		
		list.remove(1); //idx 1 객체 -> JDBC 삭제
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
		//객체를 바로 삭제
		list.remove("Java");
	
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
		System.out.println("========================================");
		
		list.clear();
		
		System.out.println(list.isEmpty()); //true
		System.out.println(list.size()); //0
	}
}
