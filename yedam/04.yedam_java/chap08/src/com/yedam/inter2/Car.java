package com.yedam.inter2;

public class Car {
	//Car 클래스의 필드에 Tire 넣기
	Tire flt = new KumhoTire();
	Tire frt = new KumhoTire();
	Tire blt = new KumhoTire();
	Tire brt = new KumhoTire();
	
	void run() {
		flt.roll();
		frt.roll();
		blt.roll();
		brt.roll();
	}
}
