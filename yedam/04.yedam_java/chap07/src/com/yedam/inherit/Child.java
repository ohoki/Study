package com.yedam.inherit;

public class Child extends Parent {
	String name;
	
	@Override
	public void getInfo()  {
		System.out.println("나의 이름은" + name + "입니다");
	}
	
	@Override
	public void method1() {
		System.out.println("자식 객체의 method1 실행");
	}
	
	public void method3() {
		System.out.println("자식 객체의 method3 실행");
	}
}
