package com.yedam.app.dept.web;

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

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptContoroller {
	
	@Autowired
	DeptService deptService;
	
	//조회(데이터, 일반페이지) -> GET	
	//등록, 수정, 삭제       -> POST
	
	//전체조회
	@GetMapping("/deptList")
	public String getdeptAllList(Model model) {
		model.addAttribute("deptList", deptService.getDeptList());
		return "dept/deptList";
	}
	
	//단건조회
	@GetMapping("/deptInfo")
	public String getDeptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.getDeptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		return "dept/deptInfo";
	}
	
	//등록 - Form
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/deptInsert";
	}
	
	//등록 - Process
	@PostMapping("deptInsert")
	public String empInsertProcess(DeptVO deptVO, RedirectAttributes rtt) {
		int result = deptService.insertDeptInfo(deptVO);
		String message = null;
		String uri = null;
		
		if(result == -1) {
			message = "정상적으로 등록되지 않았습니다.";
			uri = "deptList";
		}else {
			message = "정상적으로 등록되었습니다.\n";
			message += "부서번호 : " + result;
			uri = "deptInfo?departmentId=" + result;
		}
		rtt.addFlashAttribute("message", message);
		
//		return "redirect:deptInfo?departmentId="+result;
		return "redirect:" + uri;
	}
	
	//수정 - Process
	// 1) Client - Json -> Server : @RequestBody
	// 2) Server - Jsone -> Client : @ResponseBody
	@PostMapping("/deptUpdate")
	@ResponseBody
	public Map<String, String> empUpdateProcess(@RequestBody DeptVO deptVO) {
		return deptService.updateDeptInfo(deptVO);
	}
	
	//삭제 - Process
	@PostMapping("/deptDelete")
	@ResponseBody
	public String empDeleteProcess(@RequestParam(name = "id") int departmentId) {
		Map<String, String> map = deptService.deleteDeptInfo(departmentId);
		return map.get("결과");
	}
}
