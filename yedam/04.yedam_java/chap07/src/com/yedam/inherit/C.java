package com.yedam.inherit;

public class C extends A {
	
	public C() {
		super();
		this.field = "value";
		this.method();
	}
	
	//protected 접근제어자 메소드를 가져와서 쓰려면 상속을 해줘야 함
}
