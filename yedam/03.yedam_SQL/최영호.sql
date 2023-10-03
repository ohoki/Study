SET SERVEROUTPUT ON

-- 2)
DECLARE
    v_dept_name departments.department_name%TYPE;
    v_ejob employees.job_id%TYPE;
    v_sal employees.salary%TYPE;
    v_annual employees.salary%TYPE;
BEGIN
    SELECT d.department_name, e.job_id, NVL(e.salary, 0), (NVL(salary,0) + NVL(salary,0) * NVL(commission_pct,0)) * 12
    INTO v_dept_name, v_ejob, v_sal, v_annual
    FROM employees e JOIN departments d
    ON e.department_id = d.department_id
    WHERE e.employee_id = &사원번호;
    
    DBMS_OUTPUT.PUT ('부서이름 : ' || v_dept_name);
    DBMS_OUTPUT.PUT (' job_id : ' || v_ejob);
    DBMS_OUTPUT.PUT(' 급여 : ' || v_sal);
    DBMS_OUTPUT.PUT_LINE(' 연간 총수입 : ' || v_annual);
END;
/

-- 3)
DECLARE
    v_hdate employees.hire_date%TYPE;
BEGIN
    SELECT hire_date
    INTO v_hdate
    FROM employees
    WHERE employee_id = &사원번호;
    
    IF v_hdate > TO_DATE('2005/12/31', 'YY/MM/DD') THEN
        DBMS_OUTPUT.PUT_LINE('New employee');
    ELSE 
        DBMS_OUTPUT.PUT_LINE('Career employee');
    END IF;
END;
/

-- 4)
BEGIN
    FOR v_dan IN 1..9 LOOP
        IF v_dan = 1 OR MOD(v_dan,3) = 0 THEN
            FOR  v_count IN 1..9 LOOP
                DBMS_OUTPUT.PUT_LINE(v_dan || ' * ' || v_count || ' = ' || v_dan*v_count);
            END LOOP;
        END IF;
    END LOOP;
END;
/

-- 5)
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, first_name, NVL(salary,0) AS salary
        FROM employees
        WHERE department_id = &부서번호;
    
BEGIN
    FOR emp_record  IN emp_cursor LOOP
        DBMS_OUTPUT.PUT ('사번 : ' || emp_record.employee_id);
        DBMS_OUTPUT.PUT (' 이름 : ' || emp_record.first_name);
        DBMS_OUTPUT.PUT_LINE(' 급여 : ' || emp_record.salary);
    END LOOP;
END;
/

-- 6)
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

-- 7)
CREATE OR REPLACE FUNCTION u_info
(p_ssn VARCHAR2)
RETURN VARCHAR2
IS
    v_gender VARCHAR2(100);
    v_age NUMBER;
    v_year DATE;
    
    e_no_ssn EXCEPTION;
BEGIN
    IF SUBSTR(p_ssn, 7, 1) = 1 OR SUBSTR(p_ssn, 7, 1) = 3 THEN
        v_gender := '남자';
    ELSIF SUBSTR(p_ssn, 7, 1) = 2 OR SUBSTR(p_ssn, 7, 1) = 4 THEN
        v_gender := '여자';
    ELSE 
        RAISE e_no_ssn;
    END IF;
    
    v_year := TO_DATE(SUBSTR(p_ssn, 1, 6), 'RR/MM/DD');
    
    v_age := TRUNC(MONTHS_BETWEEN(SYSDATE ,v_year)/12) ;
        
    RETURN '만 나이 : ' || v_age || ' 성별 : ' || v_gender;     
EXCEPTION
    WHEN e_no_ssn THEN
        RETURN '잘못된 주민번호 입니다.'; 
END;
/

-- 8)
CREATE OR REPLACE FUNCTION years_of_service  
(p_eid VARCHAR2)
RETURN NUMBER
IS
    v_hdate employees.hire_date%TYPE;
    v_service_year NUMBER;
BEGIN
    SELECT hire_date
    INTO v_hdate
    FROM employees
    WHERE employee_id = p_eid;

    v_service_year := TRUNC(MONTHS_BETWEEN(SYSDATE ,v_hdate)/12) ;
    
    RETURN v_service_year;
END;
/

-- 9)
CREATE OR REPLACE FUNCTION get_mgr  
(p_dept_name VARCHAR2)
RETURN VARCHAR2
IS
    v_mgr employees.first_name%TYPE;
BEGIN
    SELECT first_name
    INTO v_mgr
    FROM employees
    WHERE employee_id = (SELECT manager_id FROM departments WHERE department_name = p_dept_name);
    
    RETURN v_mgr;
END;
/

-- 10)
SELECT name, text
FROM user_source
WHERE type IN ('PROCEDURE', 'FUNCTION', 'PACKAGE', 'PACKAGE BODY');

-- 11)
BEGIN
    FOR i IN 1..9 LOOP
        FOR  j IN 1..10-i LOOP
            DBMS_OUTPUT.PUT('-');
        END LOOP;
        FOR  j IN 1..i LOOP
            DBMS_OUTPUT.PUT('*');
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('');
    END LOOP;
END;
/