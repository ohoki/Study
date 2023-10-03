package com.yedam.app.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	
	@Autowired
	EmpMapper empMapper;
	
	@RequestMapping(value = "emp")
	public	String empList(Model model, EmpVO empVO) {
		model.addAttribute("emp", empMapper.getEmp(empVO));
		return "emp";
	}
}
