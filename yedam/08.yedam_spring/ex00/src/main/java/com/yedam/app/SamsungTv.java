package com.yedam.app;

public class SamsungTv implements Tv {

	@Override
	public void on() {
		System.out.println("삼성TV를 켰습니다.");
	}
}
