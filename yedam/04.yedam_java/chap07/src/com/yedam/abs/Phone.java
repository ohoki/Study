package com.yedam.abs;

public abstract class Phone {
	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	
	public abstract void turnOff();
}
