package com.yedam.web.emp.service;

import java.util.Date;

import lombok.Data;

@Data
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private Date hireDate;
	private String jobId;
}
