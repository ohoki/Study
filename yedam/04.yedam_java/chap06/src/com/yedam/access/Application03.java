package com.yedam.access;

public class Application03 {

	public static void main(String[] args) {
		//하나의 객체를 외부로 전달
		Singleton s1 = Singleton.getInstance();
		
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1 == s2); //true (같은객체)
		
		s1.age = 100;
		s1.name = "고길동";
		
		System.out.println(s2.age);    //100
		System.out.println(s2.name);   //고길동
		
		Member member = new Member();
		
		member.instance();
	}

}
