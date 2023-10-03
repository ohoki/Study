package com.yedam.web.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.web.common.PagingVO;
import com.yedam.web.emp.mapper.EmpMapper;
import com.yedam.web.emp.service.EmpService;
import com.yedam.web.emp.service.EmpVO;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	EmpMapper empMapper;
	
	@Override
	public int empCount() {
		return empMapper.getTotalCount();
	}

	@Override
	public List<EmpVO> getEmpList(PagingVO pagingVO) {
		return empMapper.selectEmpAll(pagingVO);
	}

}
