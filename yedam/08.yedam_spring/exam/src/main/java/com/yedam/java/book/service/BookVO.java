package com.yedam.java.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private int bookNo;
	private String bookName;
	private String bookCoverimg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date   bookDate;
	private Integer bookPrice;
	private String bookPublisher;
	private String bookInfo;
}
