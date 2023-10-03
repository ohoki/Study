package com.yedam.oop;

public class Application04 {

	public static void main(String[] args) {
		Book book1 = new Book("혼자 공부하는 자바", "학습서", "24000원", "한빛미디어", "A0001");
		
		Book book2 = new Book("자바의 정석", "학습서", "30000원", "도우출판", "A0002");
		
		book1.getInfo();
		System.out.println();
		book2.getInfo();
	}
}
