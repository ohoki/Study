package com.yedam.app.emp.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpContoroller {
	
	@Autowired
	EmpService empService;
	
	//조회(데이터, 일반페이지) -> GET	
	//등록, 수정, 삭제       -> POST
	
	//전체조회
	@GetMapping("/empList")
	public String getEmpAllList(Model model) {
		model.addAttribute("empList", empService.getEmpAll());
		return "emp/empList";
	}
	
	//단건조회
	@GetMapping("/empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmp(empVO);
		model.addAttribute("empInfo", findVO);
		//모델에 담으면 비동기 안됨
		return "emp/empInfo";
	}
	
	//등록 - Form
	@GetMapping("/empInsert")
	public String empInsertForm() {
		return "emp/empInsert";
	}
	
	//등록 - Process
	@PostMapping("/empInsert")
	public String empInsertProcess(EmpVO empVO, RedirectAttributes rtt) {
		String result = null;
		int empId = empService.insertEmp(empVO);
		
		if(empId == -1) {
			result = "정상적으로 등록되지 않았습니다.";
		}else {
			result = "정상적으로 등록되었습니다."
					+"\n등록된 사원의 사번은 " + empId + "입니다.";
		}
		
		rtt.addFlashAttribute("result", result);
		
		return "redirect:empList";
	}
	
	//수정 - Process
	// 1) Client - Json -> Server : @RequestBody
	// 2) Server - Jsone -> Client : @ResponseBody
	@PostMapping("/empUpdate")
	@ResponseBody
	public Map<String, String> empUpdateProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmp(empVO);
	}
	
	//삭제 - Process
	//produces= "text/plain;charset=UTF-8" -> 데이터를 한글로 보낼 때 인코딩 하는 것 (like Success -> 성공)
	@PostMapping(value = "/empDelete", produces= "text/plain;charset=UTF-8")
	@ResponseBody
	public String empDeleteProcess(@RequestParam(name = "id") int employeeId) {
		Map<String, String> map = empService.deleteEmp(employeeId);
		return map.get("결과");
	}
}
