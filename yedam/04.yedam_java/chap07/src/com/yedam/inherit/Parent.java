package com.yedam.inherit;

public class Parent {
	String lastName;
	
	public void getInfo() {
		System.out.println("우리 가족의 성은 " + lastName + "입니다.");
	}
	
	public void method1() {
		System.out.println("부모 객체 method1 실행");
	}
	
	public void method2() {
		System.out.println("부모 객체 method2 실행");
	}
}
