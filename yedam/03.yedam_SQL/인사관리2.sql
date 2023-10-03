--1번
SELECT employee_id, first_name, job_id, hire_date FROM employees;
--2번
SELECT DISTINCT manager_id FROM employees WHERE manager_id IS NOT NULL;
--3번
SELECT employee_id, first_name, salary, department_id FROM employees WHERE  salary BETWEEN 7000 AND 12000 AND first_name Like 'H%';
--4번
SELECT employee_id, first_name, hire_date, SUBSTR(email,1,3) "EMAIL", LENGTH(email) "EMAIL LENGH" FROM employees WHERE hire_date >= TO_DATE('2005/01/01');
--5번
SELECT first_name, hire_date, ADD_MONTHS(hire_date, 6) "입사 6개월 후의 날짜", NEXT_DAY(hire_date,'금') "입사 후 첫 금요일", 
TRUNC( MONTHS_BETWEEN(sysdate, hire_date) ) "총 근무 개월", LAST_DAY(hire_date)+1 "첫 급여일" FROM employees ORDER BY hire_date;
--6번
SELECT employee_id, first_name, TO_CHAR(hire_date, 'DD/MM/YYYY DAY') "입사일", TO_CHAR( salary*NVL(commission_pct,0), '$999,999,999.99' ) "수당" FROM employees ORDER BY "수당" DESC;
--7번
SELECT employee_id, first_name, job_id, salary, department_id FROM employees WHERE department_id IN (50, 60) AND salary >5000;
--8번
SELECT employee_id, job_id, phone_number, department_id FROM employees WHERE phone_number LIKE '515%';
--9번
SELECT employee_id, first_name, ( salary + salary*NVL(commission_pct,0) )*12 "연봉" ,SUBSTR(hire_date,1,2) "입사년도",NVL2(commission_pct,'COMM','NOCOMM') "비고", department_id  FROM employees 
ORDER BY department_id, "연봉";
--10번
SELECT employee_id, first_name, department_id,
    CASE department_id WHEN 20 THEN 'Canada'
                       WHEN 80 THEN 'UK'
                       ELSE 'USA'
    END
AS "근무지역"
FROM employees;