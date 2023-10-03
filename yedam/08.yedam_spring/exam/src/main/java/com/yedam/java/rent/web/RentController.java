package com.yedam.java.rent.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;
import com.yedam.java.rent.service.RentService;


@Controller
public class RentController {

	@Autowired
	RentService rentService;
	
	//전체 조회
	@GetMapping("rentList")
	public String rentAllList(Model model) {
		System.out.println(rentService.rentList() + "ggg");
		model.addAttribute("rentList", rentService.rentList());
		
		return "rent/rentList";
	}
}
