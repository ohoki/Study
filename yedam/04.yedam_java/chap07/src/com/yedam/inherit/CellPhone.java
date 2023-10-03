package com.yedam.inherit;

public class CellPhone {
	String model;
	String color;
	
	public CellPhone() {
		System.out.println("부모 클래스가 생성됨");
	}
	
	void powerOn() {
		System.out.println("전원을 켭니다");
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다");
	}
	
	void bell() {
		System.out.println("전화가 옵니다");
	}
	
	void hangUp() {
		System.out.println("전화가 끊습니다");
	}
}
