package com.yedam.exe;

public class Student {
	private int stdId;
	private String stdName;
	private String stdMajor;
	private int stdPoint;
	//필드 추가 (그룹 함수 사용을 위한 필드 추가)
	private double sum;
	private double avg;
	
	//getter & setter
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdMajor() {
		return stdMajor;
	}
	public void setStdMajor(String stdMajor) {
		this.stdMajor = stdMajor;
	}
	public int getStdPoint() {
		return stdPoint;
	}
	public void setStdPoint(int stdPoint) {
		this.stdPoint = stdPoint;
	}
	
	
}
