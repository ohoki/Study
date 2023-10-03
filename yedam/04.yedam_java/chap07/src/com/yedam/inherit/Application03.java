package com.yedam.inherit;

public class Application03 {
	public static void main(String[] args) {
		int r = 10;
		
		Computer com = new  Computer();
		System.out.println("원 면적 : " + com.areaCircle(r));
		
		Child child = new Child();
		
		child.getInfo();
		child.method1();
		child.method2(); //오버라이딩 되지 않았기 때문에 부모 객체가 출력된다.
		child.method3(); 
		
		SupersonicAirPlane sa = new SupersonicAirPlane();
		
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicAirPlane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SupersonicAirPlane.NORMAL;
		sa.fly();
		sa.land();
	}
}
