DESC employees;

SELECT * FROM employees;

SELECT DISTINCT department_id "부서코드" FROM employees ORDER BY department_id;

SELECT first_name||' '||last_name "이름" FROM employees;

SELECT salary FROM employees WHERE salary NOT IN(10000,15000);

SELECT first_name FROM employees WHERE first_name LIKE 'A%';

SELECT first_name FROM employees WHERE first_name LIKE '%A%' OR first_name LIKE '%T%';

SELECT first_name, salary FROM employees WHERE salary BETWEEN 15000 AND 25000 ORDER BY first_name DESC;

SELECT first_name, salary FROM employees WHERE commission_pct IS NOT NULL ORDER BY first_name DESC;

SELECT employee_id, first_name, hire_date, department_id FROM employees WHERE hire_date LIKE '02%'
MINUS
SELECT employee_id, first_name, hire_date, department_id FROM employees WHERE department_id = 100;

SELECT SYSDATE FROM DUAL;

SELECT LOWER('YE DAM'), UPPER('ye dam'), INITCAP('ye dam') FROM DUAL;

SELECT first_name FROM employees WHERE LOWER(first_name) LIKE '%a%';

SELECT first_name||'씨는 '||job_id||' 입니다' "이름" FROM employees;                                                                                

SELECT CONCAT(job_id, CONCAT(' = ',first_name)) name FROM employees;

SELECT SUBSTR(job_id,4,LENGTH(job_id)-3) FROM employees;

SELECT SUBSTR(job_id, INSTR(job_id,'_')+1, LENGTH(job_id)-3) FROM employees;

SELECT LPAD(first_name, 10, '*'), RPAD(last_name, 10, '#') FROM employees;

SELECT REPLACE(job_id, '_', ''), job_id FROM employees;

SELECT TRUNC( MONTHS_BETWEEN(sysdate, '22/03/31') ) FROM  dual;

SELECT ADD_MONTHS( '23/03/31', 6) FROM dual;

SELECT NEXT_DAY(sysdate, 7) FROM dual;

SELECT LAST_DAY(sysdate) FROM dual;

SELECT * FROM nls_session_parameters;

ALTER SESSION SET nls_date_format = 'yyyy-mm-dd';

ALTER SESSION SET nls_date_language = 'korean';

SELECT hire_date FROM employees;

SELECT TO_CHAR(hire_date, 'yyyy"년" mm dd hh:mi:ss') FROM employees;

SELECT TO_CHAR(123.4567,'l0000000.0000') FROM dual; 

SELECT TO_CHAR(salary, '$999,999.99') FROM employees;

SELECT hire_date, first_name FROM employees WHERE hire_date = TO_DATE('January 13, 2001', 'Month DD, YYYY');

--과제2--
SELECT sysdate "Date" FROM dual;

SELECT employee_id, first_name, ROUND(salary*1.15) "New Salary" FROM employees;

SELECT employee_id, first_name, salary, ROUND(salary*1.15) "New_Salary", ROUND(salary*1.15)-salary "Increase"  FROM employees;

SELECT UPPER(first_name) "UPPER_NAME", LENGTH(first_name) "LENGTH" FROM employees WHERE first_name LIKE 'A%' OR first_name LIKE 'J%' OR first_name LIKE 'M%';

SELECT UPPER(first_name) "UPPER_NAME", LENGTH(first_name) "LENGTH" FROM employees WHERE SUBSTR(first_name,1,1) IN ('A','J','M');

SELECT first_name, ROUND( MONTHS_BETWEEN(sysdate, hire_date) ) "MONTHS_WORKED" FROM employees ORDER BY hire_date;

SELECT last_name, TO_CHAR(salary, '$000000000000000') "SALARY" FROM employees;

SELECT last_name, TRUNC( (sysdate-hire_date)/7, 0) "TENURE" FROM employees WHERE department_id=90 ORDER BY TENURE DESC;

SELECT first_name, hire_date, TO_CHAR(hire_date, 'DY') day FROM employees ORDER BY ( TO_CHAR(hire_date-1, 'd') ); 

--예제 --
SELECT first_name, COMMISSION_PCT, LPAD( TO_CHAR(salary*12 + NVL2(commission_pct, commission_pct, 0), '999,999.999' ), 15, '*' )annual FROM employees;

SELECT first_name, last_name, NULLIF( LENGTH(first_name), LENGTH(last_name) ) FROM employees;

SELECT first_name, salary,
    CASE WHEN salary>20000 THEN salary*1.1
         WHEN salary>10000 THEN salary*1.2
         WHEN salary>5000 THEN salary*1.2
         ELSE salary
    END
    AS "인상급여"
FROM employees;

SELECT first_name, salary, 
        DECODE(department_id, '10', 'aaa',
                              '20', 'bbb',
                              '30', 'ccc','ddd')
AS dep   
FROM employees;

SELECT first_name, salary, job_id,
    CASE job_id WHEN 'AC_MGR' THEN salary*1.3
                WHEN 'FI_MGR' THEN salary*1.2
                WHEN 'IT_PROG' THEN salary*1.1
                ELSE salary
    END           
AS "UPSALARY"                
FROM employees;

--문제--
SELECT employee_id, first_name, salary FROM employees;

SELECT * FROM employees;

SELECT employee_id "사원 번호", first_name "사원 이름", salary FROM employees;

SELECT first_name||' 의 월급은 '||salary||' 달러입니다.' "name+salary" FROM employees;

SELECT DISTINCT job_id FROM employees;

SELECT first_name, salary FROM employees ORDER BY salary;

SELECT first_name, salary, job_id FROM employees WHERE salary In ('3000');

SELECT first_name, salary, job_id, hire_date, department_id FROM employees WHERE first_name IN ('Steven');

SELECT first_name, (salary + salary* NVL2(commission_pct, commission_pct, 0))*12 ANNUAL FROM employees WHERE (salary + salary* NVL2(commission_pct, commission_pct, 0))*12 > 90000;

SELECT first_name, salary, job_id, department_id FROM employees WHERE salary <= 12000;

SELECT first_name, job_id, department_id FROM employees WHERE job_id != 'SA_MAN';

SELECT first_name, salary FROM employees WHERE salary BETWEEN 1000 AND 3000;

SELECT first_name, salary FROM employees WHERE salary NOT BETWEEN 1000 AND 3000;

SELECT first_name, hire_date FROM employees WHERE hire_date LIKE '06%';

SELECT first_name, salary FROM employees WHERE first_name LIKE 'S%';

SELECT first_name, salary FROM employees WHERE first_name LIKE '%t';

SELECT first_name, salary FROM employees WHERE first_name LIKE '_m%';

SELECT first_name FROM employees WHERE UPPER(first_name) LIKE '%A%';

SELECT first_name, commission_pct FROM employees WHERE commission_pct IS NULL;

SELECT first_name, salary, job_id FROM employees WHERE job_id IN('SA_MAN', 'PU_CLERK', 'IT_PROG');

SELECT first_name, salary, job_id FROM employees WHERE job_id NOT IN('SA_MAN', 'PU_CLERK', 'IT_PROG');

SELECT first_name, salary, job_id FROM employees WHERE job_id = 'SA_MAN' AND  salary >= 12000;

SELECT UPPER(first_name), LOWER(first_name), INITCAP(first_name)  FROM employees;

SELECT first_name, salary FROM employees WHERE LOWER(first_name) = 'alexander';

SELECT SUBSTR('SMITH',1,3) FROM dual;

SELECT first_name, LENGTH(first_name) "철자 개수" FROM employees;

SELECT first_name, INSTR(first_name, 'a') FROM employees;

SELECT first_name, LPAD(salary,10,'*') "월급" FROM employees;

SELECT first_name, salary, LPAD(' ',salary/1000+1,'■') FROM employees;

SELECT ROUND(876.567,2) FROM dual;

SELECT TRUNC(876.567,2) FROM dual;

SELECT MOD(10, 3) FROM dual;

SELECT employee_id,
    CASE WHEN MOD(employee_id, 2)=0 THEN 0
         WHEN MOD(employee_id, 2)=1 THEN 1
    END 
AS 홀짝
FROM employees;

SELECT first_name, employee_id FROM employees WHERE MOD(employee_id, 2)=0;

SELECT first_name, ROUND( MONTHS_BETWEEN(sysdate, hire_date) )||'개월' "근무개월" FROM employees;

SELECT TO_DATE('2019-06-01') - TO_DATE('2018-10-01') "총일수" FROM dual;

SELECT TRUNC(( TO_DATE('2019-06-01','YYYY-MM-DD') - TO_DATE('2018-10-01','YYYY-MM-DD') )/7) "총주수" FROM dual;

SELECT ADD_MONTHS(TO_DATE('2019-05-01','YYYY-MM-DD'), 100) FROM dual;

SELECT TO_DATE('2019-05-01','YYYY-MM-DD') + 100 FROM dual;

SELECT NEXT_DAY( TO_DATE('2021-06-30','YYYY-MM-DD'), '화' ) FROM dual;

SELECT NEXT_DAY( TO_DATE('2021-05-22','YYYY-MM-DD'), '월' ) FROM dual;

SELECT NEXT_DAY( sysdate, '화' ) FROM dual;

SELECT NEXT_DAY( ADD_MONTHS(TO_DATE('2019-05-22','YYYY-MM-DD'), 100), '화' ) FROM dual;

SELECT NEXT_DAY( ADD_MONTHS(sysdate, 100), '월' ) FROM dual;

SELECT LAST_DAY( TO_DATE('2019-05-22','YYYY-MM-DD') ) FROM dual;

SELECT LAST_DAY(sysdate)-sysdate FROM dual;

SELECT first_name, hire_date, LAST_DAY(hire_date)  FROM employees WHERE UPPER(first_name) = 'SUSAN';

SELECT first_name, hire_date, TO_CHAR(hire_date, 'DAY') "입사 요일", TO_CHAR(salary, '999,999,999')  FROM employees WHERE UPPER(first_name) = 'DAVID';

SELECT first_name, hire_date FROM employees WHERE hire_date LIKE '08%';

SELECT first_name, TO_CHAR(salary, 'L999,999,999') FROM employees WHERE salary>1500;

SELECT first_name, hire_date FROM employees WHERE hire_date = TO_DATE('2005-06-14','YYYY-MM-DD');

SELECT first_name, NVL(commission_pct,0) FROM employees;

SELECT first_name, salary, salary * NVL(commission_pct, 0) "커미션", salary + salary * NVL(commission_pct,0) "월급과 커미션의 합" FROM employees WHERE job_id IN('SA_MAN', 'IT_PROG');

SELECT first_name,
    CASE department_id WHEN 10 THEN 300
                       WHEN 20 THEN 400
                       ELSE 0 
    END
AS "보너스"
FROM employees;

SELECT employee_id,
    CASE WHEN MOD(employee_id, 2)=0 THEN '짝수'
         WHEN MOD(employee_id, 2)=1 THEN '홀수'
    END 
AS 홀짝
FROM employees;

SELECT first_name, job_id,
    DECODE(job_id, 'SA_MAN', 500,
                             2000)
AS "보너스"                             
FROM employees;

SELECT first_name, job_id, salary,
    CASE WHEN salary>=5000 THEN 500
         WHEN salary>=3000 THEN 300
         WHEN salary>=2000 THEN 200
         ELSE 0
    END
AS "보너스"                             
FROM employees;

SELECT first_name, job_id, salary * NVL(commission_pct, 0) "커미션",
    DECODE(commission_pct, NULL, 500,
                                   0)
AS "보너스"                             
FROM employees;

SELECT first_name, job_id,
    CASE WHEN  job_id IN('SA_MAN', 'PU_CLERK') THEN 500
         WHEN  job_id IN('ST_CLERK', 'FI_ACCOUNT') THEN 500
         ELSE 0
    END
AS "보너스"                             
FROM employees;

--모의고사
DESC departments;
SELECT * FROM departments;

SELECT employee_id, first_name, department_id, salary, hire_date FROM employees ORDER BY department_id ,4 DESC;

SELECT * FROM employees WHERE commission_pct IS NOT NULL;

SELECT first_name, salary FROM employees WHERE salary NOT BETWEEN 5000 AND 12000;

SELECT first_name, hire_date, job_id FROM employees WHERE SUBSTR(hire_date,1,2) IN (02,05,07) ORDER BY hire_date;

SELECT first_name, job_id, salary, department_id FROM employees WHERE job_id LIKE '%SA%' OR job_id LIKE '%MK%';

SELECT LPAD(first_name,10,'*') FROM employees;

SELECT employee_id, first_name, salary, ROUND(salary*1.15) "New Salary" FROM employees ORDER BY "New Salary"-salary DESC;

SELECT employee_id, last_name, hire_date, ADD_MONTHS(hire_date, 6) FROM employees;

SELECT first_name, department_id, job_id, hire_date, salary FROM employees 
WHERE job_id IN ('IT_PROG', 'FI_MGR') AND salary NOT BETWEEN 10000 AND 15000 ORDER BY department_id, hire_date;

SELECT employee_id, first_name, department_id, hire_date,
    CASE department_id WHEN 40 THEN 'seoul'
                       WHEN 50 THEN 'pusan'
                       ELSE 'daegu'
    END
AS 근무지역
FROM employees;

SELECT employee_id, first_name, department_id,
    DECODE (department_id, 40, 'seoul', 50, 'pusan', 'daegu')   
AS 근무지역
FROM employees;