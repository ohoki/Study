package com.yedam.app;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainExample {
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Tv tv = (Tv)ctx.getBean("tv");
		tv.on();
	}
}
