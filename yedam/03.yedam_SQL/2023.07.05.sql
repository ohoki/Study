SET SERVEROUTPUT ON

-- Ŀ�� FOR LOOP
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, last_name 
        FROM employees;
    
    CURSOR dept_emp_cursor IS
        SELECT employee_id, last_name
        FROM employees
        WHERE department_id = &�μ���ȣ;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(emp_cursor%ROWCOUNT);
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.last_name);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('Ư�� �μ� ���');
    
    FOR emp_info IN dept_emp_cursor LOOP
    DBMS_OUTPUT.PUT_LINE(dept_emp_cursor%ROWCOUNT);
        DBMS_OUTPUT.PUT_LINE(emp_info.employee_id || ', ' || emp_info.last_name);
    END LOOP;
END;
/

-- 1) ��� ����� �����ȣ, �̸�, �μ��̸� ���

DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, last_name, department_name
        FROM employees e JOIN departments d
        ON e.department_id = d.department_id;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.last_name || ', ' || emp_record.department_name);
    END LOOP;
END;
/

DECLARE
     CURSOR emp_cursor IS
        SELECT first_name, salary, NVL(salary,0) * 12 + NVL(salary,0) * NVL(commission_pct,0) * 12 AS annual
        FROM employees
        WHERE department_id IN(50 , 80);
BEGIN
    FOR emp_record  IN emp_cursor LOOP
         DBMS_OUTPUT.PUT_LINE(emp_record.first_name || ', ' || emp_record.salary || ', ' || emp_record.annual);
    END LOOP;
END;
/

BEGIN
    FOR emp_info IN (SELECT last_name FROM employees) LOOP
         DBMS_OUTPUT.PUT_LINE(emp_info.last_name);
    END LOOP;
END;
/

--�Ű�����
DECLARE
    CURSOR emp_cursor
        (p_mgr employees.manager_id%TYPE) IS
            SELECT * FROM employees WHERE manager_id = p_mgr;
    
    emp_record emp_cursor%ROWTYPE;
BEGIN
    --�⺻
    OPEN emp_cursor(100);
    
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.first_name);
    END LOOP;
    
    CLOSE emp_cursor;
    
    DBMS_OUTPUT.PUT_LINE('================================================================');
    
    -- Ŀ�� FOR LOOP
    FOR emp_info IN emp_cursor(149) LOOP
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.first_name);
    END LOOP;    
END;
/

-- FOR UPDATE, WHERE CURRENT OF
DECLARE
    CURSOR sal_info_cursor IS
        SELECT salary, commission_pct
        FROM employees
        WHERE department_id = 30
        FOR UPDATE OF salary, commission_pct NOWAIT;
BEGIN
    FOR sal_info IN sal_info_cursor LOOP
        IF sal_info.commission_pct IS NULL THEN
            UPDATE employees
            SET salary = sal_info.salary * 1.1
            WHERE CURRENT OF sal_info_cursor;
        ELSE
            UPDATE employees
            SET salary = sal_info.salary + sal_info.salary * sal_info.commission_pct
            WHERE CURRENT OF sal_info_cursor;
        END IF;    
    END LOOP;
END;
/

-- Ŀ���� ����ؼ� -> employees ���̺��� ��� ������ �� ������ ���
DECLARE
    CURSOR emp_cursor IS
        SELECT * FROM employees;
    
    emp_record emp_cursor%ROWTYPE;
    
    TYPE emp_table_type IS TABLE OF emp_cursor%ROWTYPE
        INDEX BY PLS_INTEGER;
        
    emp_table_info emp_table_type;
BEGIN
    OPEN emp_cursor;
    
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%NOTFOUND;
        
        emp_table_info(emp_record.employee_id) := emp_record;
    END LOOP;
    
    CLOSE emp_cursor;
    DBMS_OUTPUT.PUT_LINE(emp_table_info.COUNT);
    FOR idx IN emp_table_info.FIRST .. emp_table_info.LAST LOOP
        IF NOT emp_table_info.EXISTS(idx) THEN
            CONTINUE;
        END IF;
        
        emp_record := emp_table_info(idx);
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.first_name);
    END LOOP;    
END;
/

--=========================================================
-- 1-1)
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, first_name, hire_date
        FROM employees;
        
    emp_record emp_cursor%ROWTYPE;
BEGIN
    OPEN emp_cursor;
    
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%NOTFOUND;
        IF  emp_record.hire_date < TO_DATE('2006/01/01', 'YYYY/MM/DD') THEN
            INSERT INTO test01 VALUES(emp_record.employee_id, emp_record.first_name, emp_record.hire_date);
        ELSE
            INSERT INTO test02 VALUES emp_record;
        END IF;
    END LOOP;
    
    CLOSE emp_cursor;
END;
/

-- 1-2)
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, first_name, hire_date
        FROM employees;
        
BEGIN
    FOR emp_record IN emp_cursor LOOP
       IF  emp_record.hire_date < TO_DATE('2006/01/01', 'YYYY/MM/DD') THEN
            INSERT INTO test01 VALUES(emp_record.employee_id, emp_record.first_name, emp_record.hire_date);
        ELSE
            INSERT INTO test02 VALUES(emp_record.employee_id, emp_record.first_name, emp_record.hire_date);
        END IF;
    END LOOP;
END;
/

SELECT * FROM test01;
DELETE test01;
SELECT * FROM test02;
DELETE test02;

-- 1-3)
DECLARE
    CURSOR emp_cursor IS
        SELECT first_name, hire_date, department_name
        FROM employees e JOIN departments d
        ON e.department_id = d.department_id
        WHERE e.department_id = &�μ���ȣ;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(emp_record.first_name || ', ' || emp_record.hire_date || ', ' || emp_record.department_name);
    END LOOP;
END;
/ 

-- �̹� ���ǵǾ��ְ� �̸��� �����ϴ� ���ܻ���
DECLARE
    v_ename employees.first_name%TYPE;
BEGIN
    SELECT first_name
    INTO v_ename
    FROM employees
    WHERE department_id = &�μ���ȣ;
    
    DBMS_OUTPUT.PUT_LINE(v_ename);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('�ش� �μ����� ����� �������� �ʽ��ϴ�.');
        DBMS_OUTPUT.PUT_LINE('����� ����Ǿ����ϴ�.'); -- ������ ����ؾ��ϴ� ��� ��� ���ܹ����� �־�����Ѵ�
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('�ش� �μ����� �������� ����� �����մϴ�.');
        DBMS_OUTPUT.PUT_LINE('����� ����Ǿ����ϴ�.');    
END;
/

-- �̹� ���ǵǾ������� �̸��� �������� �ʴ� ����
DECLARE
    e_emps_remaining EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_emps_remaining, -02292);
BEGIN
    DELETE FROM departments
    WHERE department_id = &�μ���ȣ;
EXCEPTION 
    WHEN e_emps_remaining THEN
         DBMS_OUTPUT.PUT_LINE('�ٸ� ���̺��� ����ϰ� �ֽ��ϴ�.');
END;
/

--����� ���� ����
DECLARE
    e_dept_del_fail EXCEPTION;
BEGIN
    DELETE FROM departments
    WHERE department_id = &�μ���ȣ;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_dept_del_fail;
    END IF;
    
EXCEPTION 
    WHEN e_dept_del_fail THEN
        DBMS_OUTPUT.PUT_LINE('�ش� �μ��� �������� �ʽ��ϴ�. �μ���ȣ�� Ȯ�����ּ���.');
END;
/

-- ���� Ʈ�� �Լ�
DECLARE
    e_too_many EXCEPTION;
    
    v_ex_code NUMBER;
    v_ex_msg VARCHAR2(1000);
    emp_info employees%ROWTYPE;
BEGIN
    SELECT *
    INTO emp_info
    FROM employees
    WHERE department_id = &�μ���ȣ;
    
    IF emp_info.salary < (emp_info.salary * emp_info.commission_pct + 10000) THEN
        RAISE e_too_many;
    END IF;
EXCEPTION
    WHEN e_too_many THEN
        DBMS_OUTPUT.PUT_LINE('����� ���� ���� �߻�!!');
    WHEN OTHERS THEN
        v_ex_code := SQLCODE;
        v_ex_msg := SQLERRM;
        DBMS_OUTPUT.PUT_LINE('ORA ' || v_ex_code);
        DBMS_OUTPUT.PUT_LINE(' - ' || v_ex_msg);
END;
/

-- 1) test_employees ���̺��� ����Ͽ� ���õ� ����� �����ϴ� PL/SQL �ۼ�
-- ����1) ġȯ���� ���
-- ����2) ����� ���� ��� '�ش����� �����ϴ�.' �޼��� ��� => ����� ���� ���ܻ���

DECLARE
    e_emp_del_fail EXCEPTION;
BEGIN
    DELETE FROM test_employees
    WHERE employee_id = &�����ȣ;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_emp_del_fail;
    END IF;
EXCEPTION
    WHEN e_emp_del_fail THEN
        DBMS_OUTPUT.PUT_LINE('�ش����� �����ϴ�.');
END;
/

-- ���ν��� (IS�� DECLARE�� ��ü��)
-- IN ���
CREATE OR REPLACE PROCEDURE raise_salary
(p_eid IN employees.employee_id%TYPE)
IS
-- ����� : ���ο��� ����ϴ� ����, Ŀ��, Ÿ�� ���� 
    v_pre_sal employees.salary%TYPE;
BEGIN
    SELECT salary
    INTO v_pre_sal
    FROM employees
    WHERE employee_id = p_eid;
    
    DBMS_OUTPUT.PUT_LINE('���� �޿� : ' || v_pre_sal);
    
    UPDATE employees
    SET salary = salary * 1.1
    WHERE employee_id = p_eid;
END;
/

BEGIN
    raise_salary(100);
END;
/

CREATE OR REPLACE PROCEDURE test_pro
(p_num IN NUMBER,
 p_result OUT NUMBER)
IS
    v_sum NUMBER;
BEGIN
    v_sum := p_num + p_result;
    p_result := v_sum;
    
    -- p_num := 4449; IN ���� ���Ҵ��ڷ� ���� �� ����
END;
/

DECLARE 
    v_result NUMBER := 1234;
BEGIN
    test_pro(1000, v_result);
    DBMS_OUTPUT.PUT_LINE('result : ' || v_result);
    -- OUT ��忡�� v_result�� ���ν����� ���鼭 ���� null�� �ٲ�� ������ ����� ���� �ʴ´�.
END;
/

-- OUT ���
CREATE PROCEDURE select_emp
(p_eid IN employees.employee_id%TYPE,
 p_ename OUT employees.first_name%TYPE,
 p_sal OUT employees.salary%TYPE,
 p_comm OUT employees.commission_pct%TYPE)
IS

BEGIN
    SELECT first_name, salary, commission_pct
    INTO p_ename, p_sal, p_comm
    FROM employees 
    WHERE employee_id = p_eid;
END;
/

DECLARE
    v_name VARCHAR2(100 char);
    v_sal NUMBER;
    v_comm NUMBER;
    
    v_eid NUMBER := &�����ȣ;
BEGIN
    select_emp(v_eid, v_name, v_sal, v_comm);
    
    DBMS_OUTPUT.PUT('�����ȣ : ' || v_eid);
    DBMS_OUTPUT.PUT(', ����̸� : ' || v_name);
    DBMS_OUTPUT.PUT(', �޿� : ' || v_sal);
    DBMS_OUTPUT.PUT_LINE(', Ŀ�̼� : ' || v_comm);   
END;
/

--IN OUT ���
-- '0539405000' -> '(053)940-5000'
CREATE PROCEDURE format_phone
(p_phone_no IN OUT VARCHAR2)
IS

BEGIN
    p_phone_no := '(' || SUBSTR(p_phone_no, 1, 3) ||
                  ')' || SUBSTR(p_phone_no, 4, 3) ||
                  '-' || SUBSTR(p_phone_no, 7);
END;
/

VARIABLE g_phone_no VARCHAR2(100);
EXECUTE : g_phone_no := '0539405000';
PRINT g_phone_no;

EXECUTE format_phone(:g_phone_no);
PRINT g_phone_no;   
