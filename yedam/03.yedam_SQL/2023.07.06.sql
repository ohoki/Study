SET SERVEROUTPUT ON
-- 1)
CREATE OR REPLACE PROCEDURE yedam_ju
(p_ssn IN VARCHAR2)
IS
    v_result VARCHAR2(100);
BEGIN
    v_result := SUBSTR(p_ssn, 1, 6) ||
                 '-' || RPAD(SUBSTR(p_ssn, 7, 1), 7, '*');
    
    DBMS_OUTPUT.PUT_LINE(v_result);               
END;
/

EXECUTE yedam_ju('9501011667777');
EXECUTE yedam_ju('0511013689977');

-- 2)
CREATE OR REPLACE PROCEDURE test_pro2
(p_eid IN employees.employee_id%TYPE)
IS
    e_emp_del_fail EXCEPTION;
BEGIN
    DELETE FROM test_employees WHERE employee_id = p_eid;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_emp_del_fail;
    END IF;

EXCEPTION
    WHEN e_emp_del_fail THEN
        DBMS_OUTPUT.PUT_LINE('해당사원이 없습니다.');    
END;
/

EXECUTE test_pro2(176);

--  =========================================================================
-- 3)
CREATE OR REPLACE PROCEDURE yedam_emp 
(p_eid IN employees.employee_id%TYPE)
IS
    v_ename employees.last_name%TYPE;
    v_result VARCHAR2(100);
BEGIN
    SELECT last_name
    INTO v_ename
    FROM employees
    WHERE employee_id = p_eid;
    
    v_result := RPAD(SUBSTR(v_ename, 1, 1), LENGTH(v_ename), '*');
    
    DBMS_OUTPUT.PUT_LINE(v_ename || '->' || v_result); 
END;
/

EXECUTE yedam_emp(176);

-- 4)
CREATE OR REPLACE PROCEDURE get_emp 
(p_dept_id IN departments.department_id%TYPE)
IS
    CURSOR emp_cursor IS
        SELECT employee_id, last_name
        FROM employees
        WHERE department_id = p_dept_id;
    
    emp_record emp_cursor%ROWTYPE;
    
    e_no_emp EXCEPTION;        
BEGIN
    OPEN emp_cursor;
    
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.last_name);
    END LOOP;
    
    IF emp_cursor%ROWCOUNT = 0 THEN
            RAISE e_no_emp;
    END IF;
    
    CLOSE emp_cursor;
    
EXCEPTION
    WHEN e_no_emp THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서에는 사원이 없습니다.');
END;
/
EXECUTE get_emp(1);

-- 5)
CREATE OR REPLACE PROCEDURE y_update 
(p_eid IN employees.employee_id%TYPE,
 p_raise_pct IN NUMBER)
IS
    e_no_emp EXCEPTION;
BEGIN
    UPDATE employees
    SET salary = salary + salary*(p_raise_pct/100)
    WHERE employee_id = p_eid;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_no_emp;
    END IF;
    
EXCEPTION
    WHEN e_no_emp THEN
        DBMS_OUTPUT.PUT_LINE('No search employee!!');    
END;
/

EXECUTE y_update(200, 10);

select * from employees where employee_id = 200;

-- 6)
CREATE OR REPLACE PROCEDURE y_proc 
(p_dept_id IN departments.department_id%TYPE)
IS
    CURSOR emp_cursor IS
        SELECT employee_id, hire_date
        FROM employees
        WHERE department_id = p_dept_id;
    
    emp_record emp_cursor%ROWTYPE;
    
    CURSOR dept_cursor IS
        SELECT department_id
        FROM departments
        WHERE department_id = p_dept_id;
    
    dept_record dept_cursor%ROWTYPE;
    
    e_no_dept EXCEPTION;
    e_no_emp EXCEPTION;
BEGIN
    OPEN dept_cursor;
    
    LOOP
        FETCH dept_cursor INTO dept_record;
        EXIT WHEN dept_cursor%NOTFOUND;
    END LOOP;
    
    IF dept_cursor%ROWCOUNT = 0 THEN
            RAISE e_no_dept;
    ELSE
        OPEN emp_cursor;
        
        LOOP
            FETCH emp_cursor INTO emp_record;
            EXIT WHEN emp_cursor%NOTFOUND;
        
            IF emp_record.hire_date >= TO_DATE('2005/01/01', 'RR/MM/DD') THEN
                INSERT INTO yedam02 values(emp_record.employee_id, emp_record.hire_date);
            ELSE
                INSERT INTO yedam01 values(emp_record.employee_id, emp_record.hire_date);
            END IF;
        END LOOP;
        
        IF emp_cursor%ROWCOUNT = 0 THEN
            RAISE e_no_emp;
        END IF;
        
        CLOSE emp_cursor;
    END IF;
    
    CLOSE dept_cursor; 
EXCEPTION
    WHEN e_no_dept THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서가 없습니다.');
    WHEN e_no_emp THEN
        DBMS_OUTPUT.PUT_LINE('해당부서에 사원이 없습니다');     
END;
/

EXECUTE y_proc(100);

SELECT * FROM yedam02;
SELECT * FROM yedam01;
DELETE FROM yedam02;
DELETE FROM yedam01;
select * from departments;