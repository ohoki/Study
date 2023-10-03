--6��
CREATE TABLE department (
depid      number(10)     PRIMARY KEY,
depname    varchar(10),
location   varchar(10),
tel        varchar(15)
);

CREATE TABLE employee (
empid      number(10)     PRIMARY KEY,
empname    varchar(10),
hiredate   date,
addr       varchar2(12),
tel        varchar(15),
depid      number(10), /* �ٷ� ����� -> REFERENCES department(depid) */
CONSTRAINT FK_depid FOREIGN KEY(depid)
REFERENCES department(depid)
);

--7��
ALTER TABLE employee ADD birthday date;

--8��
INSERT INTO department values(1003, '������', '��103ȣ', '053-222-3333');

INSERT INTO employee values(20121646, '������', TO_DATE('2012/09/01', 'YYYYMMDD'), '�λ�', '010-1234-2222', 1003, null);

--9��
ALTER TABLE employee MODIFY empname NOT NULL;

--10��
SELECT e.empname, e.hiredate, d.depname FROM employee e JOIN department d ON(e.depid = d.depid) WHERE d.depname = '�ѹ���';

--11��
DELETE employee WHERE addr = '�뱸';

--12��
UPDATE employee SET depid = (SELECT depid FROM department WHERE depname = 'ȸ����') WHERE depid = (SELECT depid FROM department WHERE depname = '������');

--13��
SELECT e.empid, e.empname, e.birthday, d.depname FROM employee e JOIN department d ON(e.depid = d.depid) WHERE e.hiredate > (SELECT hiredate FROM employee WHERE empid=20121729);

--14��
CREATE OR REPLACE VIEW affairsteam AS (
SELECT e.empname, e.addr, d.depname FROM employee e JOIN department d ON(e.depid = d.depid) WHERE d.depname = '�ѹ���');

select * from affairsteam;
select * from employee;
select * from department;

--����¡ rownum
select *
from (
        select rownum rn, e.*
        from ( select *
                from employees 
                order by last_name asc) e)
where rn between 1 and 10;       



