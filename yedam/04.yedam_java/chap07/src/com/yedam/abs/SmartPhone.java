package com.yedam.abs;

public class SmartPhone extends Phone{
	
	public SmartPhone(String owner) {
		super(owner);
	}

	@Override
	public void turnOff() {
		System.out.println("반드시 구현한 turnOff 메 소 드");
	}
	
	public void internetSearch() {
		System.out.println("인터넷 검색을 합니다.");
	}

}
