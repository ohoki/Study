package com.yedam.inherit;

public class Application01 {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("아이폰", "스그", "SK");
		
		//부모(CellPhone) 클래스
		System.out.println("모델 : " + sp.model);
		System.out.println("색상 : " + sp.color);
		//자식(SmartPhone) 클래스
		System.out.println("통신사 : " + sp.agency);

		//부모(CellPhone) 클래스
		sp.powerOn();
		sp.bell();
		sp.hangUp();
		sp.powerOff();
		
		//자식(SmartPhone) 클래스
		sp.kakao();
		sp.kakaoExit();
		sp.info();
	}

}
