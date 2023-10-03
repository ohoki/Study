SET SERVEROUTPUT ON

--FUNCTION (IN¸¸ °¡´ÉÇÔ)
CREATE FUNCTION y_sum
(p_x IN NUMBER,
 p_y IN NUMBER)
RETURN NUMBER
IS
    v_result NUMBER;
BEGIN
    v_result := p_x + p_y;
    RETURN v_result;
END;
/
-- 1)
EXECUTE DBMS_OUTPUT.PUT_LINE(y_sum(1,4));

-- 2)
VARIABLE g_result NUMBER;
EXECUTE : g_result := y_sum(2, 6);
PRINT g_result;

-- 3)
DECLARE
    v_result NUMBER;
BEGIN
    v_result := y_sum(10,11);
    DBMS_OUTPUT.PUT_LINE(v_result);
END;
/

-- 4)
SELECT y_sum(20,40) FROM dual;

-- »ç¿ø¹øÈ£¸¦ ±âÁØÀ¸·Î Á÷¼Ó»ó»ç ÀÌ¸§À» Ãâ·Â
CREATE OR REPLACE FUNCTION get_mgr
(p_eid employees.employee_id%TYPE)
RETURN VARCHAR2
IS
    v_mgr_id employees.first_name%TYPE;
BEGIN
    SELECT m.first_name
    INTO v_mgr_id
    FROM employees e JOIN employees m
    ON e.manager_id = m.employee_id
    WHERE e.employee_id = p_eid;
    
    RETURN v_mgr_id;    
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN '»ó»ç°¡ Á¸ÀçÇÏÁö ¾Ê½À´Ï´Ù.';
END;
/

SELECT employee_id, first_name, get_mgr(employee_id) as manager FROM employees;

-- ÆÑÅä¸®¾ó 
CREATE OR REPLACE FUNCTION y_factorial
(p_num NUMBER)
RETURN NUMBER
IS
    v_sum NUMBER := 0;
    e_num_null EXCEPTION;
BEGIN
    IF p_num IS NULL THEN
        RAISE e_num_null;
    END IF;
    
    FOR idx IN 0 .. p_num LOOP
        v_sum := v_sum + idx;
    END LOOP;
    IF v_sum > 0 THEN
        RETURN v_sum;
    END IF;
    
EXCEPTION
    WHEN e_num_null THEN 
        RETURN 'test';
END;
/

SELECT y_factorial(10) FROM dual;

--========================================================================
-- 1)
CREATE FUNCTION y_yedam 
(p_eid employees.employee_id%TYPE)
RETURN VARCHAR2
IS
    v_last_name employees.last_name%TYPE;
    v_first_name employees.first_name%TYPE;
BEGIN
    SELECT last_name, first_name
    INTO v_last_name, v_first_name
    FROM employees
    WHERE employee_id = p_eid;
    
    RETURN v_last_name || ' ' || v_first_name;
END;
/

SELECT employee_id, y_yedam(employee_id) FROM employees;

-- 2)
CREATE FUNCTION ydinc
(p_eid employees.employee_id%TYPE)
RETURN NUMBER
IS
    v_sal employees.salary%TYPE;
    v_raise_sal employees.salary%TYPE;
BEGIN
    SELECT salary
    INTO v_sal
    FROM employees
    WHERE employee_id = p_eid;
    
    IF v_sal <= 5000 THEN
        v_raise_sal := v_sal*(1.2);
    ELSIF v_sal <= 10000 THEN
        v_raise_sal := v_sal*(1.15);
    ELSIF v_sal <= 20000 THEN
        v_raise_sal := v_sal*(1.1);
    ELSE
        v_raise_sal := v_sal;
    END IF;
    
    RETURN v_raise_sal;
END;
/

SELECT last_name, salary, YDINC(employee_id) FROM   employees;

-- 3)
CREATE OR REPLACE FUNCTION yd_func 
(p_eid employees.employee_id%TYPE)
RETURN NUMBER
IS
    v_sal employees.salary%TYPE;
    v_comm employees.commission_pct%TYPE;  
    v_annual employees.salary%TYPE;
BEGIN
    SELECT salary, commission_pct
    INTO v_sal, v_comm
    FROM employees
    WHERE employee_id = p_eid;
    
    v_annual := (NVL(v_sal,0) + (NVL(v_sal,0) * NVL(v_comm,0))) * 12;
     
    RETURN v_annual;
END;
/

SELECT last_name, salary, YD_FUNC(employee_id) FROM employees;

-- 4)
CREATE OR REPLACE FUNCTION subname  
(p_name employees.last_name%TYPE)
RETURN VARCHAR2
IS
    v_subname VARCHAR2(100);  
BEGIN
    v_subname := RPAD(SUBSTR(p_name, 1, 1), LENGTH(p_name), '*'); 
    RETURN v_subname;
END;
/

SELECT last_name, subname(last_name) FROM   employees;

-- 5)
CREATE OR REPLACE FUNCTION y_dept  
(p_eid employees.employee_id%TYPE)
RETURN VARCHAR2
IS
    v_dept_name departments.department_name%TYPE;
    v_dept_id departments.department_id%TYPE; 
    
    e_no_emp EXCEPTION;
BEGIN
    SELECT department_id 
    INTO v_dept_id
    FROM employees 
    WHERE employee_id = p_eid;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_no_emp;
    END IF;
    
    IF v_dept_id IS NULL THEN
        v_dept_name := '¼Ò¼Ó ºÎ¼­°¡ ¾ø½À´Ï´Ù.';
    ELSE 
        SELECT department_name
        INTO v_dept_name
        FROM departments
        WHERE department_id = v_dept_id;    
    END IF;
    
    RETURN v_dept_name;
    
EXCEPTION 
    WHEN e_no_emp THEN
        DBMS_OUTPUT.PUT_LINE('»ç¿øÀÌ ¾Æ´Õ´Ï´Ù.');
END;
/

SELECT employee_id, y_dept(employee_id) FROM employees;

-- 6)
CREATE OR REPLACE FUNCTION y_ddi 
(p_day VARCHAR2)
RETURN VARCHAR2
IS
    v_ddi VARCHAR2(100);
    v_year NUMBER;
BEGIN
    IF '00' <= SUBSTR(p_day, 1,2) AND SUBSTR(p_day, 1,2) <= '23' THEN 
        v_year := 2000 + TO_NUMBER(SUBSTR(p_day, 1,2), 9999);
    ELSE
         v_year := 1900 + TO_NUMBER(SUBSTR(p_day, 1,2), 9999);
    END IF;
    
    IF MOD(v_year-1948,12) = 0 THEN
        v_ddi := 'Áã¶ì';
    ELSIF MOD(v_year-1948,12) = 1 THEN
        v_ddi := '¼Ò¶ì';
    ELSIF MOD(v_year-1948,12) = 2 THEN
        v_ddi := 'È£¶ûÀÌ¶ì';
    ELSIF MOD(v_year-1948,12) = 3 THEN
        v_ddi := 'Åä³¢¶ì';
    ELSIF MOD(v_year-1948,12) = 4 THEN
        v_ddi := '¿ë¶ì';
    ELSIF MOD(v_year-1948,12) = 5 THEN
        v_ddi := '¹ì¶ì';
    ELSIF MOD(v_year-1948,12) = 6 THEN
        v_ddi := '¸»¶ì';
    ELSIF MOD(v_year-1948,12) = 7 THEN
        v_ddi := '¾ç¶ì';
    ELSIF MOD(v_year-1948,12) = 8 THEN
        v_ddi := '¿ø¼þÀÌ¶ì';
    ELSIF MOD(v_year-1948,12) = 9 THEN
        v_ddi := '´ß¶ì';
    ELSIF MOD(v_year-1948,12) = 10 THEN
        v_ddi := '°³¶ì';
    ELSIF MOD(v_year-1948,12) = 11 THEN
        v_ddi := 'µÅÁö¶ì';
    END IF;    
    
    RETURN v_ddi;
END;
/

EXECUTE DBMS_OUTPUT.PUT_LINE(y_ddi('980901'));
