package com.yedam.app.emp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	EmpService empService;
	
	//전체조회
	@GetMapping("empList")
	public String empList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList";	
	}
	
	//단건조회
	@GetMapping("empInfo")
	public String empInfo(EmpVO empVO, Model model) {
		model.addAttribute("empInfo", empService.getEmpInfo(empVO));
		return "emp/empInfo";
	}
	
	//등록 - form
	//타임리프에서 폼으로 데이터를 넘길경우 빈 객체에 값을 담아서 보낼 수 있다 -> *{}
	@GetMapping("empInsert")
	public String empInsertForm(Model model) {
		model.addAttribute("empVO", new EmpVO());
		return "emp/empInsert";
	}
	
	//등록 - process
	@PostMapping("empInsert")
	public String empInsertProcess(EmpVO empVO) {
		empService.insertEmpInfo(empVO);
		return "redirect:empList";
	}
}
