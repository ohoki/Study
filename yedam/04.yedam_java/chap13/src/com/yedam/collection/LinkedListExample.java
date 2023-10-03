package com.yedam.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	public static void main(String[] args) {
		List<String>list1 = new ArrayList<>();
		List<String>list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		for(int i=0; i<100000; i++) {
			list1.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println("ArrayList 걸린 시간 : "  +  (endTime - startTime)+"ns");
		
		startTime = System.nanoTime();
		for(int i=0; i<100000; i++) {
			list2.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		
		System.out.println("LinkedList 걸린 시간 : "  +  (endTime - startTime)+"ns");
		
		//ArrayList 와 LinkedList 는 검색 및 추가 수정 시간의 차이가 있다 - 상황에 맞게 잘  쓰도록 하자
	}
}
