package com.yedam.java.rent.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class RentVO {
	private int rentNo;
	private int bookNo;
	private String bookName;
	private int rentPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rentDate;
	private char rentStatus;
	private int sum;
	private int count;
}
