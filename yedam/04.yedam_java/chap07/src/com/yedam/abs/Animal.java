package com.yedam.abs;

//추상 클래스
public abstract class Animal {
	//필드
	public String kind;
	
	//생성자
	
	//메소드
	public void breath() {
		System.out.println("숨을쉰다.");
	}
	
	//추상 메소드 -> 자식 클래스에서 무조건 오버라이딩해서 사용해야 한다
	public abstract void sound();
	
	
}
