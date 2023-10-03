package com.yedam.access;

public class Singleton {
	
//싱글톤 세팅
	private static Singleton singleton = null;
	
	//외부에서 객체를 생성하지 못하도록 막는 역할
	private Singleton() {}
	
	//클래스 내부에서 만든 단 하나의 객체를 외부에 츌력하기 위한 용도
	public static Singleton getInstance() {
		if(singleton == null) {
			singleton = new Singleton();
		}
		return singleton;
	}

//필드
	public String name;
	public int age;
	
//메소드
	public void info() {
		System.out.println("싱글톤의 인스턴스 메소드 info 출력");
	}
	
}
