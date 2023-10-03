package com.yedam.oop;

public class Book {
	//책이름, 책종류, 가격, 도서번호, 출판사 
	String name;
	String kind;
	String price;
	String company;
	String sn;
	
	//생성자는 2개 (기본, 모든 데이터를 받아오는 생성자)
	Book() {};
	
	Book(String name, String kind, String price, String company, String sn) {
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.company = company;
		this.sn = sn;
	}
	//모든 정보를 출력할 수 있는 getInfo() 메소드
	void getInfo() {
		System.out.println("책이름 : " + name);
		System.out.println("#내용");
		System.out.println("1) 종류 : " + kind);
		System.out.println("2) 가격 : " + price);
		System.out.println("3) 출판사 : " + company);
		System.out.println("4) 도서번호 : " + sn);
	}
	//다음과 같은 출력물 나오도록 구현
	//객체 생성할 때, 생성자를 통한 필드 초기화
	//객체.getInfo();
	//책이름 : 혼자 공부하는 자바
	//#내용
	//1) 종류 : 학습서
	//2) 가격 : 24000원
	//3) 출판사 : 한빛 미디어
	//4) 도서번호 : 0001
}
