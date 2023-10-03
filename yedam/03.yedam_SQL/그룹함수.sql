--카운트
SELECT * FROM employees;

SELECT COUNT(employee_id) AS 사원수 FROM employees; --107명

SELECT COUNT(commission_pct) AS 수당 FROM employees; --35

SELECT COUNT(DISTINCT department_id) AS 부서수 FROM employees; --11

SELECT COUNT(DISTINCT manager_id) AS 매니저수 FROM employees; --18

--합계,평균,최대,최소
SELECT TO_CHAR(SUM(salary),'$999,999,999') AS sumSalary, ROUND(AVG(salary),2) AS avgSalary ,
       MAX(salary) AS max, MIN(salary) AS min
FROM employees WHERE department_id =80;

--그룹
SELECT department_id, TO_CHAR(SUM(salary),'$999,999,999') AS sumSalary, ROUND(AVG(salary),2) AS avgSalary ,
       MAX(salary) AS max, MIN(salary) AS min
FROM employees GROUP BY department_id ORDER BY department_id;

SELECT job_id, TO_CHAR(SUM(salary),'$999,999,999') AS sumSalary, ROUND(AVG(salary),2) AS avgSalary , MAX(salary) AS max, MIN(salary) AS min, COUNT(DISTINCT employee_id) FROM employees GROUP BY job_id;

--having
SELECT department_id, TO_CHAR(SUM(salary),'$999,999,999') AS sumSalary, ROUND(AVG(salary),2) AS avgSalary ,MAX(salary) AS max, MIN(salary) AS min
FROM employees WHERE department_id != 70 GROUP BY department_id HAVING MAX(salary)>10000 ORDER BY department_id DESC;

--문제
SELECT job_id, MAX(salary) "Maximum", MIN(salary) "Minimum", SUM(salary) "Sum", ROUND( AVG(salary) ) "Average" FROM employees GROUP BY job_id;  

SELECT job_id, COUNT(employee_id) FROM employees GROUP BY job_id;

SELECT COUNT(DISTINCT manager_id) "Number of Managers" FROM employees;

SELECT MAX(salary)-MIN(salary) "DIFFERENCE" FROM employees;

SELECT manager_id, MIN(salary) FROM employees  WHERE manager_id IS NOT NULL GROUP BY manager_id HAVING MIN(salary) >= 6000 ORDER BY MIN(salary) DESC;

SELECT job_id, SUM( DECODE(department_id,20,salary,0)) "부서 20의 급여",SUM( DECODE(department_id,50,salary,0) ) "부서 50의 급여", 
               SUM( DECODE(department_id,80,salary,0) ) "부서 80의 급여",SUM( DECODE(department_id,90,salary,0) ) "부서 90의 급여", SUM(salary) "업무 별 총 급여"  
FROM employees  WHERE department_id IN (20,50,80,90) GROUP BY job_id;

--조인
SELECT COUNT(*) FROM departments;

SELECT e.first_name, e.department_id, d.department_id, d.department_name FROM employees e, departments d WHERE e.department_id = d.department_id(+); --왼쪽을 기준으로 오른쪽 테이블을 붙여라 (왼쪽 내부조인)

SELECT e.first_name, e.department_id, d.department_id, d.department_name FROM employees e, departments d WHERE e.department_id(+) = d.department_id;

SELECT e.first_name, e.salary, j.job_id, j.min_salary, j.max_salary FROM employees e, jobs j WHERE e.salary BETWEEN j.min_salary AND j.max_salary;

SELECT e2.employee_id, e2.first_name, e.employee_id, e.first_name FROM employees e, employees e2 WHERE e.manager_id = e2.employee_id(+);

SELECT e.first_name, department_id, d.department_name FROM employees e LEFT OUTER JOIN departments d USING(department_id);

SELECT e.first_name, e.department_id, d.department_name FROM employees e JOIN departments d ON(e.department_id = d.department_id) AND e.department_id = 80;

--문제
SELECT l.location_id, l.street_address, l.state_province, l.city, c.country_name FROM locations l NATURAL JOIN countries c;

SELECT e.employee_id,  department_id, d.department_name FROM employees e LEFT OUTER JOIN departments d USING (department_id);

SELECT * FROM locations;

SELECT * FROM departments;

SELECT e.last_name, e.department_id, d.department_name 
FROM employees e JOIN departments d ON(e.department_id = d.department_id) 
                 JOIN locations l ON (d.location_id = l.location_id)
AND l.city = 'Toronto';

SELECT e.last_name "Employee", e.employee_id "Emp#", e2.last_name "Manager", e2.employee_id "Mgr#" 
FROM employees e LEFT OUTER JOIN employees e2 ON(e.manager_id = e2.employee_id) ORDER BY e.employee_id;

SELECT e.last_name, department_id, e2.last_name 
FROM employees e RIGHT OUTER JOIN employees e2 USING(department_id) WHERE (e.employee_id != e2.employee_id);

DESC jobs;

SELECT e.first_name, e.job_id, d.department_name, e.salary FROM employees e LEFT OUTER JOIN departments d USING (department_id);

--서브쿼리
SELECT first_name, job_id FROM employees WHERE job_id = ( SELECT job_id FROM employees WHERE employee_id = 147 );

SELECT first_name, department_id, salary FROM employees WHERE department_id IN(SELECT department_id FROM employees WHERE first_name = 'David' );

SELECT first_name, job_id, salary FROM employees WHERE salary > (SELECT AVG(salary) FROM employees);

SELECT first_name, job_id, salary FROM employees WHERE salary < ALL(SELECT AVG(salary) FROM employees GROUP BY department_id);

--문제
SELECT e.department_id, d.department_name, e.employee_id, e.first_name, e.salary FROM employees e, departments d WHERE (e.department_id = d.department_id) AND e.salary>13000; 

SELECT department_id, d.department_name, e.employee_id, e.first_name, e.salary FROM employees e LEFT OUTER JOIN departments d USING (department_id) WHERE e.salary>13000; 

SELECT d.department_id, d.department_name, ROUND(AVG(e.salary),0),  MAX(e.salary), MIN(e.salary), COUNT(e.employee_id)
FROM employees e JOIN departments d ON(e.department_id = d.department_id) GROUP BY d.department_id, d.department_name;

SELECT e.department_id, d.department_name, e.employee_id, e.first_name, j.job_title, e.salary 
FROM employees e ,departments d, jobs j WHERE e.department_id = d.department_id(+) AND e.job_id = j.job_id 
ORDER BY e.department_id, e.first_name;

SELECT e.department_id, d.department_name, e.employee_id, e.first_name, j.job_title, e.salary 
FROM employees e LEFT OUTER JOIN departments d ON(e.department_id = d.department_id) 
                            JOIN jobs j ON(e.job_id = j.job_id) ORDER BY e.department_id, e.first_name;       
                            
SELECT e.department_id, d.department_name, e.employee_id, e.first_name, e.manager_id, e.salary, e.job_id, j.job_title, j.min_salary, j.max_salary, e2.manager_id, e2.first_name
FROM employees e, employees e2, jobs j, departments d WHERE e.department_id(+) = d.department_id 
                                                        AND e.salary BETWEEN min_salary(+) AND max_salary(+)
                                                        AND e.manager_id = e2.employee_id(+) 
ORDER BY e.department_id, e.employee_id;

SELECT e.department_id, d.department_name, e.employee_id, e.first_name, e.manager_id, e.salary, e.job_id, j.job_title, j.min_salary, j.max_salary, e2.manager_id, e2.first_name
FROM employees e RIGHT JOIN departments d ON(e.department_id = d.department_id) 
                 LEFT JOIN jobs j ON(e.salary BETWEEN min_salary AND max_salary)
                 LEFT JOIN employees e2 ON(e.manager_id = e2.employee_id) 
ORDER BY e.department_id, e.employee_id;

SELECT employee_id, first_name, department_id, job_id FROM employees WHERE (job_id, department_id)  IN (SELECT job_id, department_id FROM employees WHERE first_name = 'Adam');

--FROM에 서브쿼리
SELECT e.first_name, e.salary, e.department_id, b.salavg FROM employees e, (SELECT department_id, ROUND(AVG(salary),0) salavg FROM employees GROUP BY department_id)b
WHERE e.department_id = b.department_id AND e.salary > b.salavg ORDER BY e.department_id;

WITH b AS (SELECT department_id, ROUND(AVG(salary),0) salavg FROM employees GROUP BY department_id)
SELECT e.first_name, e.salary, e.department_id, b.salavg FROM employees e, b WHERE e.department_id = b.department_id AND e.salary > b.salavg ORDER BY e.department_id;

--문제
WITH b AS (SELECT department_id, department_name, location_id FROM departments)
SELECT e.employee_id, e.first_name, e.job_id, e.salary, e.department_id, b.department_name, b.location_id FROM employees e, b
WHERE e.department_id = b.department_id(+) AND e.department_id =30 AND e.salary < (SELECT ROUND(AVG(salary)) FROM employees);

WITH b AS (SELECT hire_date FROM employees WHERE department_id = 10)
SELECT e.employee_id, e.first_name, e.job_id, e.hire_date, e.salary FROM employees e, b
WHERE e.hire_date < ALL (b.hire_date);

WITH b AS (SELECT job_id FROM employees WHERE UPPER(first_name) = 'ALLAN')
SELECT e.employee_id, e.first_name, e.job_id, e.salary, e.department_id, d.department_name 
FROM employees e, departments d, b 
WHERE (e.department_id = d.department_id) AND e.job_id = b.job_id;

SELECT e.employee_id, e.first_name, e.job_id, e.salary, e.department_id, d.department_name 
FROM employees e, departments d 
WHERE e.salary > (SELECT AVG(salary) FROM employees) AND (e.department_id = d.department_id) ORDER BY salary, employee_id;

SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_name 
FROM employees e, departments d
WHERE(e.department_id = d.department_id) AND(job_id IN (SELECT DISTINCT job_id FROM employees WHERE department_id!=30)) AND e.department_id=20;

SELECT employee_id, first_name, job_id, salary FROM employees
WHERE salary > (SELECT MAX(salary) FROM employees WHERE job_id = 'SA_MAN' GROUP BY job_id);
