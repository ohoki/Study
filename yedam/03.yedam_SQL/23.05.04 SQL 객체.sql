SELECT * FROM user_ind_columns WHERE table_name = 'EMPLOYEES';

CREATE INDEX emp_hire_date_ind ON employees (hire_date);

DROP INDEX emp_hire_date_ind;

SELECT * FROM user_sequences;

CREATE TABLE dept
AS SELECT department_id id, department_name name FROM departments WHERE 1<>1;

ALTER SEQUENCE dept_seq INCREMENT BY 2 MAXVALUE 1000 NOCACHE;

INSERT INTO dept
values(dept_seq.NEXTVAL, 'AAA');


SELECT * FROM dept;

CREATE SYNONYM e
FOR employees;

SELECT * FROM e;
SELECT * FROM user_synonyms;

DROP SYNONYM e;

SELECT * FROM system_privilege_map;

SELECT * FROM user_col_privs_made;

