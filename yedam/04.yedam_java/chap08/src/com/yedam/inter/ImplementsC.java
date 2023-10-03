package com.yedam.inter;

public class ImplementsC implements InterfaceC {

	@Override
	public void method1() {
		System.out.println("InterfaceA - method1 실행");
	}

	@Override
	public void method2() {
		System.out.println("InterfaceB - method2 실행");
	}

	@Override
	public void method3() {
		System.out.println("InterfaceC - method3 실행");
	}
	
}
