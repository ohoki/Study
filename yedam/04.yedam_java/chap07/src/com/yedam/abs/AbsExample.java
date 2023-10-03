package com.yedam.abs;

public class AbsExample {

	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone("길동");
		sp.internetSearch();
		sp.turnOn();
		sp.turnOff();
		
		Phone p = sp;
		p.turnOn();
		p.turnOff();
		
		SmartPhone sp2 = (SmartPhone) p;
		sp2.internetSearch();
		sp2.turnOn();
		sp2.turnOff();

	}

}
