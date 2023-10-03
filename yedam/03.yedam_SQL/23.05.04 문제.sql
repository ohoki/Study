CREATE VIEW employees_vu
AS SELECT employee_id, first_name "EMPLOYEE", department_id
FROM employees;

SELECT * FROM employees_vu;
--
SELECT employee, department_id FROM employees_vu;
--
CREATE VIEW dept50 
AS SELECT employee_id "EMPNO", first_name "EMPLOYEE", department_id "DEPTNO" FROM employees
WHERE department_id = 50;

DESC dept50;
SELECT * FROM dept50;
--
CREATE OR REPLACE VIEW salary_vu
AS SELECT e.first_name "Employee", d.department_name "Department", e.salary "Salary", e.job_id "Grade(job_id)" 
FROM employees e JOIN departments d ON (e.department_id = d.department_id)
                 JOIN jobs j ON (e.salary BETWEEN j.min_salary AND j.max_salary);
                 
SELECT * FROM salary_vu;
--
CREATE SEQUENCE dept_id_seq INCREMENT BY 10 START WITH 300 MAXVALUE 1000;

SELECT * FROM user_sequences;
--
INSERT INTO dept
VALUES (dept_id_seq.NEXTVAL, 'Administration'); 

SELECT * FROM dept;
--
CREATE INDEX dept_name_idx ON dept ( name );

SELECT * FROM user_indexes;
--
CREATE SYNONYM e FOR employees;

SELECT * FROM user_synonyms;
--
CREATE TABLE PROF
( PROFNO        NUMBER(4) CONSTRAINT prof_profno_pk PRIMARY KEY,
  NAME          VARCHAR2(15) CONSTRAINT prof_name_nn NOT NULL,
  ID            VARCHAR2(15) CONSTRAINT prof_id_nn NOT NULL,
  HIREDATE      DATE,
  PAY           NUMBER(4));
  
  DESC PROF;
--
INSERT INTO prof
VALUES (1004, 'Tom', 't1004', '20/02/25', 900);

COMMIT;

UPDATE prof SET pay = 1200 WHERE profno = 1004;

DELETE prof WHERE profno = 1004;

COMMIT;

SELECT * FROM prof;
--
CREATE INDEX prof_name_idx ON prof (name);

ALTER TABLE prof DROP PRIMARY KEY;

ALTER TABLE prof ADD CONSTRAINT prof_no_pk PRIMARY KEY (profno) ;

ALTER TABLE prof ADD ( GENDER    CHAR(3) );

ALTER TABLE prof MODIFY ( NAME    VARCHAR2(20) );
--