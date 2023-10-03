CREATE TABLE my_employee
(id         NUMBER(4) CONSTRAINT my_employee_id_nn NOT NULL,
 last_name  VARCHAR2(25),
 first_name VARCHAR2(25),
 userid     VARCHAR2(8),
 salary     NUMBER(9,2));
 
 DESC my_employee;
 
 INSERT INTO my_employee (id, last_name, first_name, userid, salary)
 values (5, 'Ropeburn', 'Audery', 'Aropebur', 1550);
 
 COMMIT;
 
 UPDATE my_employee
 SET last_name = 'Drexler' WHERE id = 3;
 
 UPDATE my_employee
 SET salary = 1000 WHERE salary < 900;
 
 DELETE my_employee WHERE first_name = 'Betty';
 
 SELECT * FROM my_employee;
 
 SAVEPOINT step_1;
 
 DELETE my_employee;
 
 ROLLBACK TO step_1;
 
CREATE TABLE dept
(id         NUMBER(7) CONSTRAINT department_id_pk primary key,
 name       VARCHAR2(25));
 
 DESC dept;
 
 INSERT INTO dept
    SELECT department_id, department_name FROM departments;
  
CREATE TABLE emp
(id NUMBER(7),
 last_name VARCHAR2(25),
 first_name VARCHAR(25),
 dept_id NUMBER(7) CONSTRAINT emp_dept_id_fk REFERENCES dept(id));
 
 DESC emp;

CREATE TABLE employees2 (id, first_name, last_name, salary, dept_id)
    AS SELECT employee_id, first_name, last_name, salary, department_id FROM employees;

SELECT * FROM employees2;

ALTER TABLE employees2 READ ONLY;

ALTER TABLE employees2 READ WRITE;

INSERT INTO employees2
    values (34, 'Grant', 'Marcie', 5678, 10);

DELETE employees2;

SELECT * FROM employees2;