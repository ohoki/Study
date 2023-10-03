package yhBank.account;

import java.sql.Date;

public class Account {
//	MEMBER_ID       NOT NULL VARCHAR2(20)  
//	ACCOUNT_NUMBER  NOT NULL VARCHAR2(100) 
//	ACCOUNT_C_DATE           DATE          
//	ACCOUNT_BALANCE          NUMBER        
//	CERTIFICATION            VARCHAR2(100) 
	private String memberId;
	private String accountNumber;
	private Date accountCDate;
	private int accountBalance;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
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
}
