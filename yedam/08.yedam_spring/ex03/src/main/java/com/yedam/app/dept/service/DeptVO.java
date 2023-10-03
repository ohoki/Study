package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private int departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
	// null값이 있을 수도 있기때문에 객체인 Integer로 처리한다
}
