package com.yedam.app;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/database-context.xml")
public class EmpMapperClient {
	
	@Autowired
	EmpMapper empMapper;
	
	@Test
	public void selectAllEmp() {
		//전체조회
		List<EmpVO> empList = empMapper.selectEmpAllList();
		assertTrue(!empList.isEmpty());
	}
	
	@Test
	public void selectEmpInfo() {
		//단건조회
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(100);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		assertEquals(findVO.getLastName(), "King");
	}
	
	@Test
	public void insertEmpInfo() {
		//등록
		EmpVO empVO = new EmpVO();
		empVO.setLastName("Kang");
		empVO.setFirstName("San-Ha");
		empVO.setEmail("shKang@google.com");
		empVO.setJobId("IT_PROG");
		empVO.setSalary(5000);
		
		empMapper.insertEmpInfo(empVO);
		
		assertNotEquals(empVO.getEmployeeId(), 0);
	}	
	
	@Test
	public void updateEmpSal() {
		//급여 갱신
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1001);
		int result = empMapper.updateEmpSal(empVO, 10);
		
		assertEquals(result, 1);
	}	
	
	@Test
	public void updateEmpInfo() {
		//사원정보 수정
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(1001);
		
		EmpVO findVO = empMapper.selectEmpInfo(empVO);
		System.out.println(findVO);
		
		empVO.setEmail("sanH@naver.com");
		empVO.setSalary(6200);
		
		int result = empMapper.updateEmpInfo(empVO);

		assertEquals(result, 1);
	}	
	
	@Test
	public void deleteEmpInfo() {
		//삭제	
		int result = empMapper.deleteEmpInfo(1001);

		assertEquals(result, 1);
	}	
}
