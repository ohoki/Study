package com.yedam.oop;

public class Computer {
	//필드
	
	//생성자
	
	//메소드 (매개변수의 개수를 모를 경우)
	//1) 배열을 활용
	int sum1(int[] values) {
		int sum = 0;
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
	
	//2) 목록을 넘겨주는 방식
	int sum2(int ...values) {
		int sum = 0;
		for(int i=0; i<values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}
