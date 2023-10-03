package com.yedam.web.emp.service;

import java.util.List;

import com.yedam.web.common.PagingVO;

public interface EmpService {
	public int empCount();
	
	public List<EmpVO> getEmpList(PagingVO pagingVO);
}
