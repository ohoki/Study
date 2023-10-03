package com.yedam.inter;

public class MyClass {
	//인터페이스가 사용 할 수 있는 공간
	//1. 필드
	RemoteControl rc = new Televison();
	
	//2. 생성자
	public MyClass() {
		
	}
	
	public MyClass(RemoteControl rc) {
		this.rc = rc;
		rc.turnOn();
		rc.turnOff();
	}
	
	//3. 메소드
	public void methodA() {
		//로컬 변수 사용 가능
		RemoteControl rc = new Audio();
		rc.turnOn();
		rc.turnOff();
		
	}
	
	public void methodB(RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(4);
		rc.turnOff();
	}
}
