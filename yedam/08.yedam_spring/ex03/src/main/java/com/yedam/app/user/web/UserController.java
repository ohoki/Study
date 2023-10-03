package com.yedam.app.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.user.service.UserListVO;
import com.yedam.app.user.service.UserVO;

@Controller
public class UserController {
	
	@Autowired
	EmpService empService;
	
	@RequestMapping("/getObject")
	public String getCommandObject(UserVO userVO) {
		System.out.printf("================== %s\n", userVO.getName());
		System.out.printf("================== %d\n", userVO.getAge());
		return "";
	}
	
	@RequestMapping("getList")
	public String getCommandArray(UserListVO listVO) {
		for(UserVO userVO : listVO.getList()) {
			System.out.printf("================== %s\n", userVO.getName());
			System.out.printf("================== %d\n", userVO.getAge());
		}
		return ""; 
	}
	
	@RequestMapping("getValues")
	public String getParamValues(@RequestParam(required = false) String name, @RequestParam(defaultValue = "1") Integer age ) {
		System.out.printf("====================%s\n", name);
		System.out.printf("====================%d\n", age);
		return "";
	}
	
	@RequestMapping("users/{empid}")
	public String getPathValues(@PathVariable("empid") String id) {
		System.out.printf("==================%s\n", id);
		return "";
	}
	
	@RequestMapping("getJsonVal")
	public String getJsonValues(@RequestBody UserVO userVO) {
		System.out.printf("================== %s\n", userVO.getName());
		System.out.printf("================== %d\n", userVO.getAge());
		return "";
	}
}
