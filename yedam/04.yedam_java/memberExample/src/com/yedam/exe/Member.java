package com.yedam.exe;

public class Member {
//	MEMBER_ID    NOT NULL VARCHAR2(20)  
//	MEMBER_PW             VARCHAR2(20)  
//	MEMBER_PHONE          VARCHAR2(13)  
//	MEMBER_ADDR           VARCHAR2(100) 
//	MEMBER_GRADE          CHAR(1)     
	private String memberId;
	private String memberPw;
	private String memberPhone;
	private String memberAddr;
	private String memberGrade;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getMemberGrade() {
		return memberGrade;
	}
	public void setMemberGrade(String memberGrade) {
		this.memberGrade = memberGrade;
	}
	
	
}
