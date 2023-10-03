package com.yedam.account;

import java.sql.Date;

import lombok.Data;

@Data

public class Account {
//	ACCOUNT_ID      NOT NULL VARCHAR2(20) 
//	ACCOUNT_BALANCE          NUMBER       
//	ACCOUNT_CREATE           DATE         
//	MEMBER_ID                VARCHAR2(20) 
	
	private String accountId;
	private int accountBalance;
	private Date accountCreate;
	private String memberId;
}
