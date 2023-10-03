package com.yedam.app.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private int salary;
	private int commissionPct;
	private int managerId;
	private int departmentId;
}
