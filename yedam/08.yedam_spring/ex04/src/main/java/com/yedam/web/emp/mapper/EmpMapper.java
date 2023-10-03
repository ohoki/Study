package com.yedam.web.emp.mapper;

import java.util.List;

import com.yedam.web.common.PagingVO;
import com.yedam.web.emp.service.EmpVO;

public interface EmpMapper {
	//총 데이터 조회
	public int getTotalCount();
	
	// 전체 조회
	public List<EmpVO> selectEmpAll(PagingVO pagingVO);
}
