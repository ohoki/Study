package com.yedam.app.emp.service;

import java.util.List;

import com.yedam.app.emp.EmpVO;

public interface EmpService {
	//전체조회
	public List<EmpVO> getEmpAll();
	
	//단건조회
	public EmpVO getEmpInfo(EmpVO empVO);
	
	//등록
	public int insertEmpInfo(EmpVO empVO);
}
