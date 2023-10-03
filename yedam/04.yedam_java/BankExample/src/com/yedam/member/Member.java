package com.yedam.member;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberAuth;
	//계좌 조인을 위한 필드 추가
	private String accountId;
	private int accountBallance;
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getAccountBallance() {
		return accountBallance;
	}
	public void setAccountBallance(int accountBallance) {
		this.accountBallance = accountBallance;
	}
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
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberAuth() {
		return memberAuth;
	}
	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}
}
