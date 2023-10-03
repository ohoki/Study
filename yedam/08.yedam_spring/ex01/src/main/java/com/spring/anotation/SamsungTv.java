package com.spring.anotation;

import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTv implements Tv {

	@Override
	public void on() {
		System.out.println("삼성 TV를 켭니다.(anotation)");
	}
}
