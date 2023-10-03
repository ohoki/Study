--1번
SELECT * FROM employees WHERE UPPER(job_id) = 'ST_CLERK' AND hire_date > TO_DATE('2003/12/31', 'YYYY/MM/DD');

--2번
SELECT last_name, job_id, salary, commission_pct FROM employees WHERE commission_pct IS NOT NULL ORDER BY salary DESC;

--3번
SELECT ('The salary of ' || last_name || 'after a 10% raise is ' || ROUND(salary * 1.1)) "New salary" FROM employees WHERE commission_pct IS NULL;

--4번
SELECT last_name, TRUNC(MONTHS_BETWEEN(sysdate, hire_date)/12) "YEARS", TRUNC(MOD(MONTHS_BETWEEN(sysdate, hire_date), 12)) "MONTHS" from employees;

--5번
SELECT last_name FROM employees WHERE SUBSTR(last_name, 1, 1) IN ('J', 'K', 'L', 'M');

--6번
SELECT last_name, salary, 
        CASE WHEN commission_pct IS NULL THEN 'NO'
             ELSE 'YES' 
        END AS "COM" 
FROM employees;
--
SELECT last_name, salary, NVL2(commission_pct, 'Yes', 'No') FROM employees;

--7번
SELECT d.department_name, d.location_id, e.last_name, e.job_id, e.salary FROM departments d JOIN employees e ON(d.department_id = e.department_id) WHERE d.location_id = 1800;

--8번
SELECT COUNT(last_name) FROM employees WHERE last_name LIKE ('%n');

--
SELECT COUNT(last_name) FROM employees WHERE LOWER(SUBSTR(last_name, -1)) = 'n';

--9번
SELECT d.department_id, d.department_name, d.location_id, COUNT(e.employee_id) FROM departments d LEFT JOIN employees e ON(d.department_id = e.department_id) GROUP BY d.department_id, d.department_name, d.location_id; 

--10번
SELECT job_id FROM employees WHERE department_id IN(10, 20);

--11번
SELECT e.job_id, count(e.employee_id) "FREQUENCY" FROM departments d LEFT JOIN employees e ON(d.department_id = e.department_id) WHERE LOWER(d.department_name) IN('administration', 'executive') GROUP BY e.job_id ORDER BY 2 DESC;

--12번 (TO_DATE 사용하면 안됨)
SELECT last_name, hire_date FROM employees WHERE TO_CHAR(hire_date, 'DD') < '16';

--13번
SELECT last_name, salary, TRUNC((salary/1000),0) "THOUSANDS" FROM employees;

--14번
SELECT w.last_name,  m.last_name manager, m.salary, j.max_salary FROM employees w JOIN employees m ON(w.manager_id = m.employee_id)
                                                                                  JOIN jobs j ON(m.job_id = j.job_id)
WHERE m.salary > 15000;

--15번
SELECT department_id, MIN(salary) FROM employees GROUP BY department_id HAVING AVG(salary) = (SELECT MAX(AVG(SALARY)) FROM employees GROUP BY department_id);

SELECT * FROM departments;

SELECT * FROM employees;

SELECT * FROM jobs;