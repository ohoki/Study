package com.yedam.java.book.service;

import java.util.List;

public interface BookService {
	public List<BookVO> bookList();
	public int insertBook(BookVO bookVO);
	public int getBookNo();
}

