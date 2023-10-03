CREATE TABLE member(
member_id   varchar2(20) primary key,
member_pw   varchar2(30) not null,
member_name varchar2(12) not null,
member_phone varchar2(20) not null,
member_addr varchar2(100) not null,
member_answer varchar2(100) not null,
member_auth varchar2(10));

CREATE TABLE account(
member_id   varchar2(20) not null,
account_number varchar2(100) primary key,
account_c_date date,
account_balance number,
CONSTRAINT acc_memid_fk FOREIGN KEY (member_id) REFERENCES member(member_id));

CREATE TABLE transaction(
account_number varchar2(100) NOT NULL,
transaction_date date,
transaction_balance number,
transaction_status varchar2(10),
CONSTRAINT trs_accnum_fk FOREIGN KEY (account_number) REFERENCES account(account_number));

desc account;

SELECT * FROM account;

DELETE FROM account;

ALTER TABLE account ADD certification varchar2(100);
ALTER TABLE account DROP COLUMN certification;

COMMIT;

insert into member values('admin001','1234','包府磊001','010-1111-1111','措备堡开矫 吝备 yh篮青','yh篮青','A');