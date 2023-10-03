package com.yedam.web.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;                 //게시글 번호 - primary key
	private String title;            //게시글 제목 - not null
	private String contents;         //게시글 내용
	private String writer;           //게시글 작성자 -not null
	//default : yyyy/MM/dd -> input[type=date] : yyyy-MM-dd
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regidate;           //게시글 등록일자 - not null
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;         //게시글 수정날짜
	private String image;            //게시글 첨부파일
}
