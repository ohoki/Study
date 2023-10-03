package com.yedam.access;

public class Student {
	/*
	 * 이름, 학과, 학년, 과목별 점수
	 * 과목 -> programming, database, os
	 * 필드들은 모두 private
	 * setter 메소드를 활용해서 필드 초기화
	 * getter 메소드를 활용해서 객체의 필드 reading
	 * getInfo() 학생의 정보 출력
	 */
	//필드
	private String stdName;
	private String major;
	private String stdGrade;
	private int programing;
	private int database;
	private int os;
	
	//생성자 (기본 생성자)
	
	//메소드
	//setter - 데이터 입력
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	//getter - 데이터 읽기
	public String getStdName() {
		return stdName;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMajor() {
		return major;
	}
	
	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}
	public String getStdGrade() {
		return stdGrade;
	}
	
	//과목의 점수 입력
	//프로그래밍 점수가 0점보다 낮은 점수(음수)가 입력될 경우 프로그래밍 점수를 0점으로 하겠다.
	public void setPrograming(int programing) {
		if(programing < 0) { 
			this.programing = 0; 
			return;
		} 
		this.programing = programing;
		//삼항연산자
//		this.programing = (programing < 0) ? 0 : programing;  
	}
	public int getPrograming() {
		return programing;
	}
	
	public void setDatabase(int database) {
		this.database = database;
	}
	public int getDatabase() {
		return database;
	}
	
	public void setOs(int os) {
		this.os = os;
	}
	public int getOs() {
		return os;
	}
}
