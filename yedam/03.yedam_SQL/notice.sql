CREATE TABLE notice(
notice_id number not null primary key,
notice_writer VARCHAR2(50),
notice_title VARCHAR2(200),
notice_subject VARCHAR2(4000),
notice_wdate DATE,
notice_hit NUMBER DEFAULT 0);

select * from notice;

insert into notice values(2, '박기자', '테스트를 위한 더미', '이것은 더미 데이터 입니다.', sysdate, 0);
insert into notice values(3, '박기자', '테스트를 위한 더미', '이것은 더미 데이터 입니다.', sysdate, 0);

COMMIT;

CREATE TABLE member(
member_id VARCHAR2(50) primary key,
member_pw VARCHAR2(256) NOT NULL,
member_name VARCHAR2(50) NOT NULL,
member_age NUMBER,
member_tel VARCHAR2(20) NOT NULL,
member_gender VARCHAR2(10) NOT NULL);

SELECT * FROM member;

insert into member(member_id, member_pw, member_name, member_tel, member_gender) values('micol@aaa.com', '1234', '마이콜', '010-1111-1111', 'M');

insert into member values('totori@aaa.com', '1234', '토토리', 30, '010-1111-1111', 'F');

SELECT * FROM notice order by notice_id desc;