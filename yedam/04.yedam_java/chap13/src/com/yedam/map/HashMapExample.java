package com.yedam.map;

import java.util.*;

public class HashMapExample {
	public static void main(String[] args) {
		//key : String, value : Integer
		//Key와value 를 묶어서 Map.entry 라고 한다
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		//Map.entry 저장
		map.put("고길동", 85);
		map.put("김또치", 90);  //먼저 넣은 데이터가 삭제됨?!
		map.put("고희동", 80);
		map.put("김또치", 30);
		
		//entry 수 
		System.out.println("총 Entry 수 : " + map.size());  //3개
		
		//key를 활용한 객체 찾기
		System.out.println(map.get("김또치")); //30 -> 김또치,90 의 데이터가 중복으로 인해 사라짐
		System.out.println();
		
		//반복자(iterator)
		Set<String> keySet = map.keySet();
		
		//Set을 활용한 반복
		Iterator<String> keyIterator = keySet.iterator();
		while(keyIterator.hasNext()) {
			String key = keyIterator.next();
			Integer value = map.get(key);
			System.out.println("key : " + key + " value : " + value);
		}
		
		//Map.entry -> Set(반복자)
		//EntrySet <K, V> 다 가져오는 Entry 작성
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, Integer>> entryIter = entrySet.iterator();
		
		while(entryIter.hasNext()) {
			Map.Entry<String, Integer> entry = entryIter.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("key : " + key + " value : " + value);
		}
		
		//향상된 for 문
		for(Map.Entry<String, Integer> mEntry : entrySet) {
			String key = mEntry.getKey();
			Integer value = mEntry.getValue();
			System.out.println("key : " + key + " value : " + value);
		}
		
		//Entry 삭제
		map.remove("고길동");
		System.out.println("총 Entry 수 : " + map.size());
		
		//Entry 전체 삭제
		map.clear();
		System.out.println("총 Entry 수 : " + map.size());
		
	}
}
