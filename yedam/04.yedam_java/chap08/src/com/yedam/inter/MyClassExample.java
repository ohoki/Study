package com.yedam.inter;

public class MyClassExample {
	public static void main(String[] args) {
		System.out.println("(1) 필드 ========================");
		
		MyClass myClass = new MyClass();
		
		myClass.rc.turnOn();
		myClass.rc.setVolume(1);
		
		System.out.println("(2) 생성자 ===========================");
			MyClass myClass2 = new MyClass(new Audio());
			
			myClass2.rc.turnOn();
			myClass2.rc.turnOff();
			
			System.out.println("(3) 메소드 ===========================");
			MyClass myClass3 = new MyClass();
			myClass3.methodA();
			
			System.out.println("(4) 메소드 ===========================");
			MyClass myClass4 = new MyClass();
			myClass4.methodB(new Televison());
			myClass4.methodB(new Audio());
	}
}
