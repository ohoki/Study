package com.yedam.web.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.web.common.PagingVO;
import com.yedam.web.emp.service.EmpService;
import com.yedam.web.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	//전체조회
	@GetMapping("empList")
	public String empList(Model model
			              , @RequestParam(value="nowPage", defaultValue="1") Integer nowPage
			              , @RequestParam(value="cntPerPage", defaultValue="10") Integer cntPerPage) {
		int total = empService.empCount();
		PagingVO pagingVO = new PagingVO(total, nowPage, cntPerPage);
		
		System.out.println(pagingVO.getStart());
		System.out.println(pagingVO.getEnd());
		
		List<EmpVO> empList = empService.getEmpList(pagingVO);
		
		
		model.addAttribute("empList", empList);
		model.addAttribute("paging", pagingVO);
		
		return "emp/empList";
	}
}
