CREATE TABLE dept
(deptno         number(4) primary key,
 dname          varchar2(30) not null,
 loc            number(4));
 
 INSERT INTO dept (deptno, dname, loc)
 values (10, 'accounting', 1700);
 
 INSERT INTO dept (deptno, dname, loc)
 values (20, 'research', 1800);
 
 INSERT INTO dept (deptno, dname, loc)
 values (30, 'sales', 1800);
 
 INSERT INTO dept (deptno, dname)
 values (40, 'sales');
 
 INSERT INTO dept (deptno, dname, loc)
 values (50, 'sales', null);
 
 INSERT INTO dept
    SELECT department_id, department_name, location_id 
    FROM departments
    WHERE department_id > 100;
 
 DELETE dept
    WHERE deptno = 50;
    
COMMIT;

DELETE dept
    WHERE deptno = 30;

ROLLBACK;
 
UPDATE dept
SET loc = 2000
WHERE deptno = 10;

COMMIT;
delete dept;

ROLLBACK;

SELECT * FROM dept;

DROP TABLE dept;

ROLLBACK;

--¹®Á¦
CREATE TABLE s_emp
(empid      number(6) primary key,
 empname    varchar2(20) not null,
 mgr        number(6),
 sal        number(8,2),
 deptid     number(4));
 
 INSERT INTO s_emp
    SELECT employee_id, first_name, manager_id, salary, department_id FROM employees
    WHERE department_id = 30;
    
UPDATE s_emp SET sal = 5000 WHERE empid = 117;

UPDATE s_emp SET empname = 'yedam' WHERE empid = 118;

UPDATE s_emp SET deptid = (SELECT department_id FROM employees WHERE first_name = 'Lex') WHERE empid=117;

UPDATE s_emp SET empname = (SELECT first_name FROM employees WHERE employee_id =  125) WHERE empid=115;

INSERT INTO s_emp (empid, empname, mgr, sal, deptid)
values (111, 'hong gil ddong', null, 3320, 100);

DELETE s_emp WHERE empid=111;

COMMIT;

SELECT * FROM s_emp;