package com.yedam.inherit;

public class SmartPhone extends CellPhone {
	String agency;
	
	SmartPhone(String model, String color, String agency) {
		//상속받은 자식 클래스를 생성할 경우 -> 부모 클래스가 먼저 생성된 뒤에 자식 클래스가 생성됨 -> super();
		this.model = model;
		this.color = color;
		this.agency = agency;
	}
	
	void kakao() {
		System.out.println("카카오톡을 실행합니다");
	}
	
	void info() {
		System.out.println("통신사 : " + agency + "입니다");
	}
	
	void kakaoExit() {
		System.out.println("카카오톡을 종료합니다");
	}
}
