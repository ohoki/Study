SET SERVEROUTPUT ON

-- 기본 LOOP

DECLARE
    v_num NUMBER(2,0) := 1;
    v_result NUMBER(2,0) := 0;
BEGIN

    LOOP
        v_result := v_result + v_num;
        v_num := v_num + 1;
        EXIT WHEN v_num > 10;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(v_result); 
END;
/

-- FOR LOOP
BEGIN
    
    FOR num IN REVERSE 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(num);
    END LOOP;
END;                                                                                                               
/

DECLARE
    v_result NUMBER(2,0) := 0;
BEGIN
    FOR num IN 1..10 LOOP
        v_result := v_result + num;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(v_result);
END;
/

-- WHILE LOOP
DECLARE 
    v_num NUMBER(2,0) := 0;
    v_result NUMBER(2,0) := 0;
BEGIN
    WHILE v_num < 10 LOOP
        v_num := v_num + 1;
        v_result := v_result + v_num;
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(v_result);
END;
/

--====================================================================
--(1-1)
DECLARE
    v_message VARCHAR2(100) := '*';
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_message);
        v_message := v_message || '*';
        EXIT WHEN v_message = '******';
    END LOOP;
END;
/

--(1-2)
DECLARE
    v_message VARCHAR2(100) := '*';
BEGIN
    FOR num IN 1..5 LOOP
        DBMS_OUTPUT.PUT_LINE(v_message); 
        v_message := v_message || '*';
    END LOOP;
END;
/

--(1-3)
DECLARE
    v_message VARCHAR2(100) := '*';
    v_num number(2,0) := 0;
BEGIN
    WHILE v_num <5 LOOP
        DBMS_OUTPUT.PUT_LINE(v_message);
        v_message := v_message || '*';
        v_num := v_num + 1;
    END LOOP;
END;
/

--(2-1)
DECLARE
    v_num number(2,0) := &구구단;
    v_count number(2,0) := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(v_num || ' * ' || v_count || ' = ' || v_num*v_count);
        v_count := v_count + 1;
        EXIT WHEN v_count = 10;
    END LOOP;
END;
/

--(2-2)
DECLARE
    v_num number(2,0) := &구구단;
BEGIN
    FOR v_count IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE(v_num || ' * ' || v_count || ' = ' || v_num*v_count);
    END LOOP;
END;
/



--(2-3)
DECLARE
    v_num number(2,0) := &구구단;
    v_count number(2,0) := 1;
BEGIN
    WHILE v_count < 10 LOOP
        DBMS_OUTPUT.PUT_LINE(v_num || ' * ' || v_count || ' = ' || v_num*v_count);
        v_count := v_count + 1;
    END LOOP;
END;
/

--(3-1)
DECLARE
    v_dan number(2,0) := 2;
    v_count number(2,0) := 1;
BEGIN
    WHILE v_dan < 10 LOOP
        WHILE v_count < 10 LOOP
            DBMS_OUTPUT.PUT_LINE(v_dan || ' * ' || v_count || ' = ' || v_dan*v_count);
            v_count := v_count + 1;
        END LOOP;
        v_dan := v_dan + 1;
        v_count := 1;
    END LOOP;
END;
/

--(3-2)
BEGIN
    FOR v_dan IN 2..9 LOOP
        FOR  v_count IN 1..9 LOOP
            DBMS_OUTPUT.PUT_LINE(v_dan || ' * ' || v_count || ' = ' || v_dan*v_count);
        END LOOP;
    END LOOP;
END;
/

--(3-3)
DECLARE
    v_dan number(2,0) := 2;
    v_count number(2,0) := 1;
BEGIN
    LOOP
        LOOP
            DBMS_OUTPUT.PUT_LINE(v_dan || ' * ' || v_count || ' = ' || v_dan*v_count);
            v_count := v_count + 1;
            EXIT WHEN v_count >= 10;
        END LOOP;
        v_dan := v_dan + 1;
        v_count := 1;
        EXIT WHEN v_dan >= 10;
    END LOOP;
END;
/

--(4)
BEGIN
    FOR v_dan IN 1..9 LOOP
        IF (MOD(v_dan, 2) = 0) THEN
            CONTINUE;
        ELSE     
            FOR  v_count IN 1..9 LOOP
                DBMS_OUTPUT.PUT_LINE(v_dan || ' * ' || v_count || ' = ' || v_dan*v_count);
            END LOOP;
        END IF;
    END LOOP;
END;
/


--RECORD
DECLARE
    TYPE emp_record_type IS RECORD
        (empno NUMBER(6,0) NOT NULL := 100,
         ename employees.first_name%TYPE,
         salary employees.salary%TYPE);
         
    emp_info emp_record_type;
    emp_record emp_record_type;
BEGIN
    DBMS_OUTPUT.PUT_LINE('사원번호 : ' || emp_info.empno);
    DBMS_OUTPUT.PUT_LINE('사원번호 : ' || emp_record.empno);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || emp_info.salary);
    
    SELECT employee_id, first_name, salary
    INTO emp_info
    FROM employees
    WHERE employee_id = &사원번호;
    
    DBMS_OUTPUT.PUT ('사원번호 : ' || emp_info.empno);
    DBMS_OUTPUT.PUT (' 사원이름 : ' || emp_info.ename);
    DBMS_OUTPUT.PUT_LINE(' 급여 : ' || emp_info.salary);
    
END;
/

DECLARE
    emp_record employees%ROWTYPE;
BEGIN
    SELECT *
    INTO emp_record
    FROM employees
    WHERe employee_id = &사원;
    
    DBMS_OUTPUT.PUT ('사원번호 : ' || emp_record.employee_id);
    DBMS_OUTPUT.PUT (' 사원이름 : ' || emp_record.employee_id);
    DBMS_OUTPUT.PUT_LINE(' 급여 : ' || emp_record.job_id);
END;
/

--TABLE
DECLARE
    TYPE num_table_type IS TABLE OF NUMBER
        INDEX BY PLS_INTEGER;
    
    num_info num_table_type;
BEGIN

    num_info(10) := 1000;
    DBMS_OUTPUT.PUT_LINE(num_info(10));
 
    FOR idx IN 1..10 LOOP
        num_info(TRUNC(idx/2)) := idx;
    END LOOP;    

    DBMS_OUTPUT.PUT_LINE(num_info(0));
    DBMS_OUTPUT.PUT_LINE(num_info(1));
END;
/ 

DECLARE
    TYPE num_table_type IS TABLE OF NUMBER
        INDEX BY BINARY_INTEGER;
    
    num_table num_table_type;
    v_total NUMBER(2,0);
BEGIN
-- 정수 1~50 사이에 존재하는 2의 배수를 따로 num_table에 담고 총 몇개인지 출력
    
    FOR idx IN 1..50 LOOP
        IF MOD(idx, 2) <> 0 THEN
            CONTINUE;
        END IF;
        
        num_table(idx) := idx;
    END LOOP;
    
    v_total := num_table.COUNT;
    DBMS_OUTPUT.PUT_LINE(v_total);
    
--2) 실제로 num_table 내에 존재하는 모든 숫자를 출력
    FOR idx IN num_table.FIRST .. num_table.LAST LOOP
        IF num_table.EXISTS(idx) THEN
            IF MOD(num_table(idx), 3) = 0 THEN
                num_table.DELETE(idx);
            END IF;
        END IF;
    END LOOP;
    
    FOR idx IN num_table.FIRST .. num_table.LAST LOOP
        IF num_table.EXISTS(idx) THEN
            DBMS_OUTPUT.PUT_LINE(num_table(idx));   
        END IF;
    END LOOP;
END;
/

--========================================================================
DECLARE
    v_min employees.employee_id%TYPE; --최소 사원번호
    v_max employees.employee_id%TYPE; --최대 사원번호
    v_result NUMBER(1,0);             --사원의 존재유무를 확인
    emp_record employees%ROWTYPE;     --Employees 테이블의 한 행에 대응
    
    TYPE emp_table_type IS TABLE OF emp_record%TYPE
        INDEX BY PLS_INTEGER;
    
    emp_table emp_table_type;
BEGIN
    -- 최소 사원번호, 최대 사원번호
    SELECT MIN(employee_id), MAX(employee_id)
    INTO v_min, v_max
    FROM employees;
    
    FOR eid IN v_min .. v_max LOOP
        SELECT COUNT(*)
        INTO v_result
        FROM employees
        WHERE employee_id = eid;
        
        IF v_result = 0 THEN
            CONTINUE;
        END IF;
        
        SELECT *
        INTO emp_record
        FROM employees
        WHERE employee_id = eid;
        
        emp_table(eid) := emp_record;
    END LOOP;
    
    FOR eid IN emp_table.FIRST .. emp_table.LAST LOOP
        IF emp_table.EXISTS(eid) THEN
            DBMS_OUTPUT.PUT(emp_table(eid).employee_id || ', ');
            DBMS_OUTPUT.PUT(emp_table(eid).first_name || ', ');
            DBMS_OUTPUT.PUT_LINE(emp_table(eid).hire_date);
        END IF;    
    END LOOP;
END;
/

-- CURSOR
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, last_name
        FROM employees;
        
    v_eid employees.employee_id%TYPE;
    v_ename employees.last_name%TYPE;
BEGIN
    OPEN emp_cursor;
    
    LOOP    
        FETCH emp_cursor INTO v_eid, v_ename;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(v_eid || ', ' || v_ename);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE(emp_cursor%ROWCOUNT);
    
    CLOSE emp_cursor;
    --DBMS_OUTPUT.PUT_LINE(emp_cursor%ROWCOUNT); 커서 종료 후 속성 접근 불가
END;
/

-- 1) 현재 모든 사원의 사원번호, 부서이름 출력
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, first_name, department_name
        FROM employees e JOIN departments d
        ON e.department_id = d.department_id;
    
    v_eid employees.employee_id%TYPE;        
    v_ename employees.first_name%TYPE;
    v_dept_name departments.department_name%TYPE;
BEGIN
    OPEN emp_cursor;
    
    LOOP
        FETCH emp_cursor INTO v_eid, v_ename, v_dept_name;
        EXIT WHEN emp_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(v_eid || ', ' || v_ename || ', ' || v_dept_name);
    END LOOP;
    
    CLOSE emp_cursor;
END;
/

-- 2) 부서 번호가 50이거나 80인 사원의 사원이름, 급여 , 연봉 출력
DECLARE
    CURSOR emp_cursor IS
        SELECT first_name, salary, NVL(salary,0) * 12 + NVL(salary,0) * NVL(commission_pct,0) * 12 AS annual
        FROM employees
        WHERE department_id IN(50 , 80);
    
    emp_info emp_cursor%ROWTYPE;        
BEGIN
    OPEN emp_cursor;
    
    LOOP
        FETCH emp_cursor INTO emp_info;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(emp_info.first_name || ', ' || emp_info.salary || ', ' || emp_info.annual);
    END LOOP;
    
    CLOSE emp_cursor;
END;
/ 
-- 2-2)
DECLARE
    CURSOR emp_cursor IS
        SELECT first_name, salary, commission_pct
        FROM employees
        WHERE department_id IN(50 , 80);
    
    emp_info emp_cursor%ROWTYPE;        
    v_annual employees.salary%TYPE;
BEGIN
    OPEN emp_cursor;
    
    LOOP
        v_annual := NVL(emp_info.salary,0) * 12 + NVL(emp_info.salary,0) * NVL(emp_info.commission_pct,0) * 12;
        FETCH emp_cursor INTO emp_info;
        EXIT WHEN emp_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(emp_info.first_name || ', ' || emp_info.salary || ', ' || v_annual);
    END LOOP;
    
    CLOSE emp_cursor;
END;
/