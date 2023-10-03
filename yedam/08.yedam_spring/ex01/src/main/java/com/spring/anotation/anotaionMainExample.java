package com.spring.anotation;

import org.springframework.context.support.GenericXmlApplicationContext;

public class anotaionMainExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Tv tv = (Tv)ctx.getBean("tv");
		tv.on();
	}
}
