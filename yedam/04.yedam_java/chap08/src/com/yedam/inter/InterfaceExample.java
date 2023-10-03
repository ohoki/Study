package com.yedam.inter;

public class InterfaceExample {

	public static void main(String[] args) {
		//인터페이스는 스스로 객체 x
		//구현 클래스의 도움을 받아야 함
		RemoteControl rc = new Televison();
		
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(12);
		rc.setVolume(-1);
		rc.turnOff();
		rc.search("www.naver.com");
		
		System.out.println("==============================================================");
		
		rc = new Audio();
		
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(12);
		rc.setVolume(-1);
		rc.turnOff();
		
		System.out.println("==============================================================");
		
		InterfaceC ic = new ImplementsC();
		ic.method1();
		ic.method2();
		ic.method3();
	}
}
