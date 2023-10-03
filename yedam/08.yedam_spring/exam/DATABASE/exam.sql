--1) �������� ����
CREATE TABLE book_tbl_06 (
    book_no NUMBER PRIMARY KEY,
    book_name VARCHAR2(50) NOT NULL,
    book_coverimg VARCHAR2(20),
    book_date DATE,
    book_price NUMBER,
    book_publisher VARCHAR2(50),
    book_info VARCHAR2(2000)
);

DESC book_tbl_06;

--2) �������� ���õ�����
INSERT INTO book_tbl_06 VALUES (100, '������', '100.jpg', TO_DATE('2015/09/02'), 24000, '���轺', '�ü��, DB����, ��Ʈ��ũ����, ����ȯ�汸��');
INSERT INTO book_tbl_06 VALUES (101, '�ڹ�', '101.jpg', TO_DATE('2016/01/10'), 20000, '���ڹ�', '���α׷��� ���');
INSERT INTO book_tbl_06 VALUES (102, '�ڹ������α׷���', '102.jpg', TO_DATE('2016/10/30'), 25000, '������', '����ȯ��/�������α׷�/��ġ���α׷�');
INSERT INTO book_tbl_06 VALUES (103, '���¼ҽ�Ȱ���ϱ�', '103.jpg', TO_DATE('2017/09/01'), 30000, '�ڿ���', '�������, ����, ����');
INSERT INTO book_tbl_06 VALUES (104, 'HTML', '104.jpg', TO_DATE('2018/04/04'), 10000, 'ȫ�浿', 'HTML/CSS/JAVASCRIPT/JQUERY');

SELECT * FROM book_tbl_06;

--3) �����뿩���� ����
CREATE TABLE rent_tbl_06 (
    rent_no NUMBER PRIMARY KEY,
    book_no NUMBER NOT NULL,
    rent_price NUMBER NOT NULL,
    rent_date DATE NOT NULL,
    rent_status CHAR(1) DEFAULT 0 NOT NULL
);

DESC rent_tbl_06;

--4) �����뿩���� ���õ�����
INSERT INTO rent_tbl_06 VALUES (10001, 100, 2400, TO_DATE('2018/07/02'), 1);
INSERT INTO rent_tbl_06 VALUES (10002, 101, 2000, TO_DATE('2018/07/04'), 1);
INSERT INTO rent_tbl_06 VALUES (10003, 100, 2400, TO_DATE('2018/08/02'), 1);
INSERT INTO rent_tbl_06 VALUES (10004, 100, 2400, TO_DATE('2018/08/12'), 1);
INSERT INTO rent_tbl_06 VALUES (10005, 102, 2500, TO_DATE('2018/08/13'), 1);
INSERT INTO rent_tbl_06 VALUES (10006, 103, 3000, TO_DATE('2018/08/13'), 1);
INSERT INTO rent_tbl_06 VALUES (10007, 103, 3000, TO_DATE('2018/08/20'), 0);
INSERT INTO rent_tbl_06 VALUES (10008, 100, 2400, TO_DATE('2018/09/03'), 1);
INSERT INTO rent_tbl_06 VALUES (10009, 100, 2400, TO_DATE('2018/09/08'), 1);
INSERT INTO rent_tbl_06 VALUES (10010, 100, 2400, TO_DATE('2018/09/14'), 0);
INSERT INTO rent_tbl_06 VALUES (10011, 102, 2500, TO_DATE('2018/09/14'), 0);

SELECT * FROM rent_tbl_06;