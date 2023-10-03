package yhBank.member;

import java.sql.Date;

public class Member {
//	MEMBER_ID     NOT NULL VARCHAR2(20) 
//	MEMBER_PW     NOT NULL VARCHAR2(30) 
//	MEMBER_NAME            VARCHAR2(12)  
//	MEMBER_PHONE           VARCHAR2(20)  
//	MEMBER_ADDR            VARCHAR2(100) 
//	MEMBER_ANSWER          VARCHAR2(100) 
//	MEMBER_AUTH            VARCHAR2(10)
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberAddr;
	private String memberAnswer;
	private String memberAuth;
	private String accountNumber;
	private Date accountCDate;
	private int accountBalance;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Date getAccountCDate() {
		return accountCDate;
	}
	public void setAccountCDate(Date accountCDate) {
		this.accountCDate = accountCDate;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
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
	public String getMemberAnswer() {
		return memberAnswer;
	}
	public void setMemberAnswer(String memberAnswer) {
		this.memberAnswer = memberAnswer;
	}
	public String getMemberAuth() {
		return memberAuth;
	}
	public void setMemberAuth(String memberAuth) {
		this.memberAuth = memberAuth;
	}
}
