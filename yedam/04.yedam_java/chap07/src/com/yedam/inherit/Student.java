package com.yedam.inherit;

public class Student extends People{
	int stdNo;
	
	public Student(String name, String ssn, int stdNo) {
		super(name, ssn);
		this.stdNo = stdNo;
	}
	
}
