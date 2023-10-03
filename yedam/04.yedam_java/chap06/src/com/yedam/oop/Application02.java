package com.yedam.oop;

public class Application02 {
	public static void main(String[] args) {
		Bycle bycle = new Bycle();
		
		bycle.setGas(5);
		
		boolean gasState = bycle.isLeftGas();
		if(gasState) {
			System.out.println("출발합니다.");
			bycle.run();
		}
		
		if(bycle.isLeftGas()) {
			System.out.println("gas를 주입할 필요가 없습니다.");
		} else {
			System.out.println("gas를 주입하세요.");
		}
	}
}
