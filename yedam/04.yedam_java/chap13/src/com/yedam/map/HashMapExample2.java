package com.yedam.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		map.put(new Student(1, "김또치"), 85);
		map.put(new Student(1, "김또치"), 90);
		
		System.out.println("총 Entry 수 : " + map.size()); // 1개
		//해시코드와 이퀄스의 오버라이딩으로 맵에 들어가는 데이터의 중복 여부를 설정할 수 있다.
	}
}
