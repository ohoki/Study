package com.yedam.poly;

public class Child extends Parent {
	public String field2;
	
	@Override
	public void method2() {
		System.out.println("Child - method2");
	}
	
	public void method3() {
		System.out.println("Child - method3");
	}
}
