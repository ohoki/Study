package com.spring.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlMainExample {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Tv tv = (Tv)ctx.getBean("xmlTv");
		tv.on();
	}
}
