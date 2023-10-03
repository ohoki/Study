package com.yedam.java.rent.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;
import com.yedam.java.rent.service.RentVO;

public interface RentMapper {
	public List<RentVO> rentList();
}
