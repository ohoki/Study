package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.emp.EmpVO;
import com.yedam.app.emp.mapper.EmpMapper;

@SpringBootTest
class Ex05ApplicationTests {
	
	@Autowired
	EmpMapper empMapper;
	
	
	@Test
	void selectAllTest() {
		List<EmpVO> empList = empMapper.selectAllEmp();
		assertTrue(!empList.isEmpty());
	}

}
