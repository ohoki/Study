package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;


@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	//전체 조회
	@GetMapping("bookList")
	public String bookAllList(Model model) {
		model.addAttribute("bookList", bookService.bookList());
		
		return "book/bookList";
	}
	
	//등록
	@GetMapping("bookInsert")
	public String bookInsertForm(Model model) {
		model.addAttribute("bookNo", bookService.getBookNo());
		return "book/bookInsert";
	}
	
	//등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		bookService.insertBook(bookVO);
		return "redirect:bookList";
	}
}
