package com.yedam.oop;

public class Car {
	//멤버 - 필드
	String name;
	int price;
	String company ="벤틀리";
	
	//멤버 - 생성자
	//인스턴스를 만들 때 내가 하고 싶은 행위를 정의 / 클래스 이름과 동일해야 하며 다양한 방법으로 인스턴스를 생성하기 위해 오버로딩 할 수 있다.
	Car(){
		//기본 생성자
	}
	
	Car(String name, int price){
		
	}
	
	Car(int price, String company){
		
	}
	
	Car(String name){
		this(name, 1000, "현대");
//		this.name = name;
		System.out.println("자동차 이름만 입력");
	}
	
	Car(int price){
	
	}
	
	Car(String name, int price, String company){
		this.name = name;
		this.price = price;
		this.company = company;
		System.out.println("모든 필드 초기화");
	}
	
	//멤버 - 메소드 : 객체가 사용할 수 있는 기능
	void run() {
		System.out.println("자동차가 달립니다.");
	}
	
	String info() {
		String data = company + " : " + name + " : " + price;
		return data;
	}
	
	
	
}
