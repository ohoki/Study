SET SERVEROUTPUT ON

-- 커서 FOR LOOP
DECLARE
    CURSOR emp_cursor IS
        SELECT employee_id, last_name 
        FROM employees;
    
    CURSOR dept_emp_cursor IS
        SELECT employee_id, last_name
        FROM employees
        WHERE department_id = &부서번호;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(emp_cursor%ROWCOUNT);
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.last_name);
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('특정 부서 출력');
    
    FOR emp_info IN dept_emp_cursor LOOP
    DBMS_OUTPUT.PUT_LINE(dept_emp_cursor%ROWCOUNT);
        DBMS_OUTPUT.PUT_LINE(emp_info.employee_id || ', ' || emp_info.last_name);
    END LOOP;
END;
/

-- 1) 모든 사원의 사원번호, 이름, 부서이름 출력

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

--매개변수
DECLARE
    CURSOR emp_cursor
        (p_mgr employees.manager_id%TYPE) IS
            SELECT * FROM employees WHERE manager_id = p_mgr;
    
    emp_record emp_cursor%ROWTYPE;
BEGIN
    --기본
    OPEN emp_cursor(100);
    
    LOOP
        FETCH emp_cursor INTO emp_record;
        EXIT WHEN emp_cursor%NOTFOUND;
        
        DBMS_OUTPUT.PUT_LINE(emp_record.employee_id || ', ' || emp_record.first_name);
    END LOOP;
    
    CLOSE emp_cursor;
    
    DBMS_OUTPUT.PUT_LINE('================================================================');
    
    -- 커서 FOR LOOP
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

-- 커서를 사용해서 -> employees 테이블의 모든 정보를 한 변수에 담기
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
        WHERE e.department_id = &부서번호;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        DBMS_OUTPUT.PUT_LINE(emp_record.first_name || ', ' || emp_record.hire_date || ', ' || emp_record.department_name);
    END LOOP;
END;
/ 

-- 이미 정의되어있고 이름도 존재하는 예외사항
DECLARE
    v_ename employees.first_name%TYPE;
BEGIN
    SELECT first_name
    INTO v_ename
    FROM employees
    WHERE department_id = &부서번호;
    
    DBMS_OUTPUT.PUT_LINE(v_ename);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서에는 사원이 존재하지 않습니다.');
        DBMS_OUTPUT.PUT_LINE('블록이 종료되었습니다.'); -- 무조건 출력해야하는 경우 모든 예외문구에 넣어줘야한다
    WHEN TOO_MANY_ROWS THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서에는 여러명의 사원이 존재합니다.');
        DBMS_OUTPUT.PUT_LINE('블록이 종료되었습니다.');    
END;
/

-- 이미 정의되어있지만 이름이 존재하지 않는 예외
DECLARE
    e_emps_remaining EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_emps_remaining, -02292);
BEGIN
    DELETE FROM departments
    WHERE department_id = &부서번호;
EXCEPTION 
    WHEN e_emps_remaining THEN
         DBMS_OUTPUT.PUT_LINE('다른 테이블에서 사용하고 있습니다.');
END;
/

--사용자 정의 예외
DECLARE
    e_dept_del_fail EXCEPTION;
BEGIN
    DELETE FROM departments
    WHERE department_id = &부서번호;
    
    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_dept_del_fail;
    END IF;
    
EXCEPTION 
    WHEN e_dept_del_fail THEN
        DBMS_OUTPUT.PUT_LINE('해당 부서는 존재하지 않습니다. 부서번호를 확인해주세요.');
END;
/

-- 예외 트랩 함수
DECLARE
    e_too_many EXCEPTION;
    
    v_ex_code NUMBER;
    v_ex_msg VARCHAR2(1000);
    emp_info employees%ROWTYPE;
BEGIN
    SELECT *
    INTO emp_info
    FROM employees
    WHERE department_id = &부서번호;
    
    IF emp_info.salary < (emp_info.salary * emp_info.commission_pct + 10000) THEN
        RAISE e_too_many;
    END IF;
EXCEPTION
    WHEN e_too_many THEN
        DBMS_OUTPUT.PUT_LINE('사용자 정의 예외 발생!!');
    WHEN OTHERS THEN
        v_ex_code := SQLCODE;
        v_ex_msg := SQLERRM;
        DBMS_OUTPUT.PUT_LINE('ORA ' || v_ex_code);
        DBMS_OUTPUT.PUT_LINE(' - ' || v_ex_msg);
END;
/

-- 1) test_employees 테이블을 사용하여 선택된 사원을 삭제하는 PL/SQL 작성
-- 조건1) 치환변수 사용
-- 조건2) 사원이 없는 경우 '해당사원이 없습니다.' 메세지 출력 => 사용자 정의 예외사항

DECLARE
    e_emp_del_fail EXCEPTION;
BEGIN
    DELETE FROM test_employees
    WHERE employee_id = &사원번호;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE e_emp_del_fail;
    END IF;
EXCEPTION
    WHEN e_emp_del_fail THEN
        DBMS_OUTPUT.PUT_LINE('해당사원이 없습니다.');
END;
/

-- 프로시저 (IS가 DECLARE를 대체함)
-- IN 모드
CREATE OR REPLACE PROCEDURE raise_salary
(p_eid IN employees.employee_id%TYPE)
IS
-- 선언부 : 내부에서 사용하는 변수, 커서, 타입 예외 
    v_pre_sal employees.salary%TYPE;
BEGIN
    SELECT salary
    INTO v_pre_sal
    FROM employees
    WHERE employee_id = p_eid;
    
    DBMS_OUTPUT.PUT_LINE('이전 급여 : ' || v_pre_sal);
    
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
    
    -- p_num := 4449; IN 모드는 피할당자로 사용될 수 없다
END;
/

DECLARE 
    v_result NUMBER := 1234;
BEGIN
    test_pro(1000, v_result);
    DBMS_OUTPUT.PUT_LINE('result : ' || v_result);
    -- OUT 모드에서 v_result가 프로시져로 들어가면서 값이 null로 바뀌기 때문에 출력이 되지 않는다.
END;
/

-- OUT 모드
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
    
    v_eid NUMBER := &사원번호;
BEGIN
    select_emp(v_eid, v_name, v_sal, v_comm);
    
    DBMS_OUTPUT.PUT('사원번호 : ' || v_eid);
    DBMS_OUTPUT.PUT(', 사원이름 : ' || v_name);
    DBMS_OUTPUT.PUT(', 급여 : ' || v_sal);
    DBMS_OUTPUT.PUT_LINE(', 커미션 : ' || v_comm);   
END;
/

--IN OUT 모드
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
