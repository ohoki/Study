--drop table slip;
create table slip (
	SLIP_NO      number primary key,	
	SLIP_AMOUNT   number,		
	SLIP_DT     varchar2(8),
	SAL_DT	 	varchar2(8),
	CUSTOMER     varchar2(50),		
	BANK_ACCT    varchar2(20)
);
