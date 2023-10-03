package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper")
public class Ex05Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex05Application.class, args);
	}
}
