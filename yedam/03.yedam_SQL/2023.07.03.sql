SET SERVEROUTPUT ON

DECLARE 
    v_sal NUMBER(7,2) := 60000;
    v_comm v_sal%TYPE := v_sal * .20;
    v_message VARCHAR2(255) := 'eligible for commission';

BEGIN   
    DBMS_OUTPUT.PUT_LINE('v_sal ' || v_sal); --60000
    DBMS_OUTPUT.PUT_LINE('v_comm ' || v_comm); -- 12000
    DBMS_OUTPUT.PUT_LINE('v_message ' || v_message); -- eligible for commission
    DBMS_OUTPUT.PUT_LINE('===========================');
    
    DECLARE
        v_sal NUMBER(7,2) := 50000;
        v_comm v_sal%TYPE := 0;
        v_total_comp NUMBER(7,2) := v_sal + v_comm;
    BEGIN
        DBMS_OUTPUT.PUT_LINE('v_sal ' || v_sal); -- 50000
        DBMS_OUTPUT.PUT_LINE('v_comm ' || v_comm); -- 0
        DBMS_OUTPUT.PUT_LINE('v_message ' || v_message); -- eligible for commission
        DBMS_OUTPUT.PUT_LINE('v_total_comp ' || v_total_comp);  --50000
        DBMS_OUTPUT.PUT_LINE('==========================='); 
        v_message := 'CLERK not ' || v_message; --����
        v_comm := v_sal * .30; --����
    END;
    
    DBMS_OUTPUT.PUT_LINE('v_sal ' || v_sal); --60000
    DBMS_OUTPUT.PUT_LINE('v_comm ' || v_comm); --12000
    DBMS_OUTPUT.PUT_LINE('v_message ' || v_message); -- CLERK not eligible for commission
    DBMS_OUTPUT.PUT_LINE('===========================');
    v_message := 'SALESMAN ' || v_message;
    DBMS_OUTPUT.PUT_LINE('v_message ' || v_message); -- SALESMAN CLERK not eligible for commission
END;
/
 
DECLARE
    v_empid employees.employee_id%TYPE;
    v_ename VARCHAR2(100);
BEGIN
    SELECT employee_id, first_name || ', ' || last_name
    INTO v_empid, v_ename
    FROM employees
    WHERE employee_id = &�����ȣ;
    
    DBMS_OUTPUT.PUT_LINE('�����ȣ : ' || v_empid);
    DBMS_OUTPUT.PUT_LINE('�����ȣ : ' || v_ename);
END;  
/

DECLARE 
    v_deptno departments.department_id%TYPE;
    v_comm employees.commission_pct%TYPE := 0.1;
BEGIN
    SELECT department_id
    INTO v_deptno
    FROM employees
    WHERE employee_id = &�����ȣ;

    INSERT INTO employees (employee_id, last_name, email, hire_date, job_id, department_id)
    VALUES (1000, 'Hong', 'hkd@google.com', sysdate, 'IT_PROG', v_deptno);
    
    UPDATE employees SET salary = (NVL(salary,0) + 10000) * v_comm
    WHERE employee_id = 1000;
END;
/
DECLARE
    v_empid employees.employee_id%TYPE;
BEGIN
    SELECT employee_id INTO v_empid FROM employees WHERE salary IS NULL;

    DELETE FROM employees
    WHERE employee_id = v_empid;
END;
/

SELECT * FROM employees WHERE employee_id = 1000;

CREATE TABLE test_employees AS SELECT * FROM employees;

BEGIN
    DELETE FROM test_employees
    WHERE employee_id = &�����ȣ;
    
    UPDATE test_employees SET salary = salary * 1.1
    WHERE employee_id = &�����ȣ;
    
    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('�ش� ����� �������� �ʽ��ϴ�.');
    END IF;
    -- DBMS_OUTPUT.PUT_LINE('������, ' || SQL%ROWCOUNT || '�� �����Ǿ����ϴ�.');
END;
/

-- ===================================================================

DECLARE
    v_empid employees.employee_id%TYPE;
    v_ename VARCHAR2(100);
    v_deptid departments.department_id%TYPE;
    v_deptname VARCHAR2(100); 
BEGIN
    SELECT employee_id, last_name, department_id
    INTO v_empid, v_ename, v_deptid
    FROM employees 
    WHERE employee_id = &�����ȣ;
    
    SELECT department_name
    INTO v_deptname
    FROM departments
    WHERE department_id = v_deptid;
    
    DBMS_OUTPUT.PUT_LINE('�����ȣ : ' || v_empid);
    DBMS_OUTPUT.PUT_LINE('����̸� : ' || v_ename);
    DBMS_OUTPUT.PUT_LINE('�μ��̸� : ' || v_deptname);
END;
/

-- 1)
DECLARE
    v_ename VARCHAR(100);
    v_salary NUMBER(7,2);
    v_annualsalary NUMBER(10,2);
BEGIN
    SELECT last_name, salary, (salary*12 + (NVL(salary,0)*NVL(commission_pct,0)*12)) 
    INTO v_ename, v_salary, v_annualsalary
    FROM employees 
    WHERE employee_id = &�����ȣ;
    
    DBMS_OUTPUT.PUT_LINE('����̸� : ' || v_ename);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || v_salary);
    DBMS_OUTPUT.PUT_LINE('���� : ' || v_annualsalary);
END;
/

-- 2)
DECLARE
    v_ename VARCHAR(100);
    v_sal NUMBER(7,2);
    v_comm employees.commission_pct%TYPE;
    v_annual NUMBER(10,2);
BEGIN
    SELECT last_name, salary, commission_pct
    INTO v_ename, v_sal, v_comm
    FROM employees 
    WHERE employee_id = &�����ȣ;
           
    v_annual :=  v_sal*12 + NVL(v_sal,0) * NVL(v_comm,0)*12;
    
    DBMS_OUTPUT.PUT_LINE('����̸� : ' || v_ename);
    DBMS_OUTPUT.PUT_LINE('�޿� : ' || v_sal);
    DBMS_OUTPUT.PUT_LINE('���� : ' || v_annual);
END;
/

-- ======================================================================

-- �⺻ IF��
BEGIN
    DELETE FROM test_employees
    WHERE employee_id = &�����ȣ;
    
    IF SQL%ROWCOUNT = 0 THEN
        DBMS_OUTPUT.PUT_LINE('�ش� ����� �������� �ʽ��ϴ�.');
    END IF;
END;
/

-- IF - ELSE �� : ����� ����
DECLARE
    v_count NUMBER(5,2);
BEGIN
    SELECT COUNT(employee_id)
    INTO v_count
    FROM employees 
    WHERE manager_id = &�����ȣ;
    
    IF v_count = 0 THEN
        DBMS_OUTPUT.PUT_LINE('�Ϲ� ����Դϴ�.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('�����Դϴ�.');
    END IF;
END;    
/

-- IF - ELSEIF - ELSE �� : ����
DECLARE
    v_hdate NUMBER;
BEGIN
    SELECT TRUNC(MONTHS_BETWEEN(sysdate, hire_date)/12)
    INTO v_hdate
    FROM employees    
    WHERE employee_id = &�����ȣ;
    
    IF v_hdate < 5 THEN --(5���� ���� �Ǽ���)
        DBMS_OUTPUT.PUT_LINE('�Ի��� �� 5�� �̸��Դϴ�.');
    ELSIF v_hdate < 10 THEN --(5���� ũ�ų� ���� 10���� ���� �Ǽ���)
        DBMS_OUTPUT.PUT_LINE('�Ի��� �� 10�� �̸��Դϴ�.');
    ELSIF v_hdate < 15 THEN --(10���� ũ�ų� ���� 15���� ���� �Ǽ���)
        DBMS_OUTPUT.PUT_LINE('�Ի��� �� 15�� �̸��Դϴ�.');
    ELSE --(15���� ũ�ų� ���� �Ǽ���)
        DBMS_OUTPUT.PUT_LINE('�Ի��� �� 15�� �̻��Դϴ�.');
    END IF;
END;
/

--=============================================================
-- 1)
DECLARE
    v_hdate date;
BEGIN
    SELECT hire_date
    INTO v_hdate
    FROM employees
    WHERE employee_id = &�����ȣ;
    
    IF v_hdate > TO_DATE('2005/12/31', 'RR/MM/DD') THEN
        DBMS_OUTPUT.PUT_LINE('New employee');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('Career employee');
    END IF;
END;
/

-- 2)
DECLARE
    v_hdate date;
    v_message VARCHAR2(100);
    v_year VARCHAR2(100);
BEGIN
    SELECT hire_date
    INTO v_hdate
    FROM employees
    WHERE employee_id = &�����ȣ;
    
    v_year := TO_CHAR(v_hdate, 'yyyy');
    
    IF v_year > '2005' THEN
        v_message := 'New employee';
    ELSE 
        v_message := 'Career employee';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE(v_message);
END;
/

--=================================================

create table emp00(empid, ename, hiredate)
as
  select employee_id, first_name, hire_date
  from   employees
  where  employee_id = 0;

DECLARE
    v_empid employees.employee_id%TYPE;
    v_ename employees.first_name%TYPE;
    v_hdate employees.hire_date%TYPE;
    v_deptid employees.department_id%TYPE;
    v_sql VARCHAR2(100);
BEGIN
    SELECT employee_id, first_name, hire_date, TRUNC(department_id/10)
    INTO v_empid, v_ename, v_hdate, v_deptid
    FROM employees
    WHERE employee_id = &�����ȣ;
    
    IF v_deptid BETWEEN 1 AND 5 THEN
        v_sql := 'INSERT INTO emp' || (v_deptid * 10) || ' VALUES(' || v_empid || ', ''' || v_ename || ''', ''' || v_hdate || ''')';
        EXECUTE IMMEDIATE v_sql;
    ELSE 
        INSERT INTO emp00 VALUES(v_empid, v_ename, v_hdate);
    END IF;

    /*
    IF v_deptid = 10 THEN
        INSERT INTO emp10 VALUES(v_empid, v_ename, v_hdate);
    ELSIF v_deptid = 20 THEN    
        INSERT INTO emp20 VALUES(v_empid, v_ename, v_hdate);
    ELSIF v_deptid = 30 THEN    
        INSERT INTO emp30 VALUES(v_empid, v_ename, v_hdate);
    ELSIF v_deptid = 40 THEN    
        INSERT INTO emp40 VALUES(v_empid, v_ename, v_hdate);
    ELSIF v_deptid = 50 THEN    
        INSERT INTO emp50 VALUES(v_empid, v_ename, v_hdate);
    ELSE    
        INSERT INTO emp00 VALUES(v_empid, v_ename, v_hdate);
    END IF;
    */
END;
/

select * from employees;
select * from emp50;
--====================================================
DECLARE
    v_ename employees.first_name%TYPE;
    v_salary employees.salary%TYPE;
    v_raise_salary v_salary%TYPE;
BEGIN
    SELECT first_name, salary
    INTO v_ename, v_salary
    FROM employees
    WHERE employee_id = &�����ȣ;
    
    IF v_salary <= 5000 THEN
        v_raise_salary := v_salary * 1.20;
    ELSIF v_salary <= 10000 THEN     
        v_raise_salary := v_salary * 1.15;
    ELSIF v_salary <= 15000 THEN     
        v_raise_salary := v_salary * 1.10;
    ELSE     
        v_raise_salary := v_salary;
    END IF;
    
     DBMS_OUTPUT.PUT_LINE('����̸� : ' || v_ename);
     DBMS_OUTPUT.PUT_LINE('�޿� : ' || v_salary);
     DBMS_OUTPUT.PUT_LINE('�λ� �� �޿� : ' || v_raise_salary);
END;
/