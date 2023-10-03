package com.yedam.access;

public class Access {
	/*
	 * 접근 제어자 : 필드, 메소드, 클래스, 생성자, 인터페이스 등 앞에 사용 가능
	 * public : 어디서든 누구나 다 사용할 수 있다.
	 * protected : 같은 패키지 내에서만 사용 가능, 다른 패키지일 경우에는 사용 X
	 *             상속이 관계의 부모, 자식의 경우에도 사용 가능(패키지 달라도 가능)
	 * default : 같은 패키지 내에서만 사용 가능, 다른 패키지일 경우에는 사용 X
	 * private : 내가 속한 클래스, 객체에서만 사용 가능   
	 * 
	 * === 생성자에 접근 제한을 걸어주어 객체를 생성하는 범위를 제한할 수 있다. ====
	 */
	
	public String free;
	protected String parent;
	String basic; //기본값 - default
	private String privacy;
	
	
	public Access() {
		
	}
	
	protected Access(int a) {
		
	}
	
	Access(String a) {
		
	}
	
	private Access(double a) {
		
	}
	
	//메소드
	private void info() {
		System.out.println("private 메소드 실행!!");
	}
	
	public void instead() {
		info();
	}
	
	
	
	
}
