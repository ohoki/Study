package com.yedam.exam;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SlipDAO {

	@Autowired private SqlSessionTemplate mybatis;
	
	public int insertSlip(Slip slip) {
		return mybatis.insert("SlipDAO.insertSlip", slip);
	}
}
