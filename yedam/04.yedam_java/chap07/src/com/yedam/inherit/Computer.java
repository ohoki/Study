package com.yedam.inherit;

public class Computer extends Calculator {
	
	@Override // 어노테이션 (자바에 알려주기 위한 표시)
	double areaCircle(double r) {
		System.out.println("Computer 객체의 메소드 실행");
		return Math.PI * r * r;
	}
}
