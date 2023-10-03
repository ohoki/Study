package com.yedam.app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpTest {
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void getEmp() {
		EmpVO vo = new EmpVO();
		vo.setEmployee_id("100");
		EmpVO findVO = empMapper.getEmp(vo);
		assertEquals(findVO.getFirst_name(), "Steven");
	}
}
