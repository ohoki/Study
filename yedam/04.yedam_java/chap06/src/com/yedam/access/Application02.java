package com.yedam.access;

public class Application02 {

	public static void main(String[] args) {
		// 인스턴스(객체) 생성
		Student std = new Student();
		
		//인스턴스 필드 -> 데이터 입력
		std.setStdName("김또치");
		std.setMajor("컴공과");
		std.setStdGrade("2학년");
		std.setPrograming(-5);
		std.setDatabase(50);
		std.setOs(-50);
		
		//인스턴스 필드 -> 데이터 얻기 및 읽기
		System.out.println("이름 : " + std.getStdName());
		System.out.println("전공 : " + std.getMajor());
		System.out.println("학년 : " + std.getStdGrade());
		System.out.println("프로그래밍 : " + std.getPrograming());
		System.out.println("데이터베이스 : " + std.getDatabase());
		System.out.println("운영체제 : " + std.getOs());
		
		Member m1 = new Member();
		
		m1.setId("dully!");
		m1.setPw("1234");
		m1.setName("둘리");
		m1.setAge(300);
		
		System.out.println(m1.getId());
		System.out.println(m1.getPw());
		System.out.println(m1.getName());
		System.out.println(m1.getAge());
	}

}
