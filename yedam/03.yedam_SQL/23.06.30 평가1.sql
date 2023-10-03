--6¹ø
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
depid      number(10), /* ¹Ù·Î ¸¸µé±â -> REFERENCES department(depid) */
CONSTRAINT FK_depid FOREIGN KEY(depid)
REFERENCES department(depid)
);

--7¹ø
ALTER TABLE employee ADD birthday date;

--8¹ø
INSERT INTO department values(1003, '¿µ¾÷ÆÀ', 'º»103È£', '053-222-3333');

INSERT INTO employee values(20121646, 'ÀÌÀ¶Èñ', TO_DATE('2012/09/01', 'YYYYMMDD'), 'ºÎ»ê', '010-1234-2222', 1003, null);

--9¹ø
ALTER TABLE employee MODIFY empname NOT NULL;

--10¹ø
SELECT e.empname, e.hiredate, d.depname FROM employee e JOIN department d ON(e.depid = d.depid) WHERE d.depname = 'ÃÑ¹«ÆÀ';

--11¹ø
DELETE employee WHERE addr = '´ë±¸';

--12¹ø
UPDATE employee SET depid = (SELECT depid FROM department WHERE depname = 'È¸°èÆÀ') WHERE depid = (SELECT depid FROM department WHERE depname = '¿µ¾÷ÆÀ');

--13¹ø
SELECT e.empid, e.empname, e.birthday, d.depname FROM employee e JOIN department d ON(e.depid = d.depid) WHERE e.hiredate > (SELECT hiredate FROM employee WHERE empid=20121729);

--14¹ø
CREATE OR REPLACE VIEW affairsteam AS (
SELECT e.empname, e.addr, d.depname FROM employee e JOIN department d ON(e.depid = d.depid) WHERE d.depname = 'ÃÑ¹«ÆÀ');

select * from affairsteam;
select * from employee;
select * from department;

--ÆäÀÌÂ¡ rownum
select *
from (
        select rownum rn, e.*
        from ( select *
                from employees 
                order by last_name asc) e)
where rn between 1 and 10;       



