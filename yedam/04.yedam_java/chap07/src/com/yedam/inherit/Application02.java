package com.yedam.inherit;

public class Application02 {

	public static void main(String[] args) {
		Student std = new Student("또치", "111-111", 1);
		
		//부모 객체 ( 상속받은 필드 )
		System.out.println("name : " + std.name);
		System.out.println("ssn : " + std.ssn);
		
		//자식 객체의 필드
		System.out.println("stdNo : " + std.stdNo);
	}

}
