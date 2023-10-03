package com.yedam.inter2;

public class Bus implements Vehicle {

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");

	}
	
	public void checkFare() {
		System.out.println("버스 승차 요금 확인");
	}
}
