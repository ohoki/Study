--�׷��Լ�
SELECT job_id, MAX(salary) "Maximum", MIN(salary) "Minimum", SUM(salary) "Sum", ROUND(AVG(salary),0) "Average" 
FROM employees GROUP BY job_id;

SELECT job_id, COUNT(employee_id) FROM employees GROUP BY job_id;

SELECT COUNT(DISTINCT manager_id)  "Number of Managers" FROM employees;

SELECT MAX(salary) - MIN(salary) "DIFFERENCE" FROM employees;

SELECT manager_id, MIN(salary) FROM employees 
WHERE manager_id IS NOT NULL GROUP BY manager_id HAVING( MIN(salary) >=6000) ORDER BY 2 DESC;

SELECT job_id, SUM( DECODE(department_id,20,salary,0) ) "20�� �μ�",
               SUM( DECODE(department_id,50,salary,0) ) "50�� �μ�",
               SUM( DECODE(department_id,80,salary,0) ) "80�� �μ�",
               SUM( DECODE(department_id,90,salary,0) ) "90�� �μ�",
               SUM(salary) "�޿� �Ѿ�"
FROM employees WHERE department_id IN(20,50,80,90) GROUP BY job_id;
--����
SELECT l.location_id, l.street_address, l.city, l.state_province, c.country_name
FROM locations l NATURAL JOIN countries c;

SELECT e.last_name, department_id, d.department_name 
FROM employees e LEFT JOIN departments d USING(department_id);

SELECT e.last_name, e.job_id, department_id, d.department_name 
FROM employees e LEFT JOIN departments d USING(department_id)
                 LEFT JOIN locations l USING(location_id)
WHERE UPPER(l.city) = 'TORONTO';

SELECT e.last_name "Employee", e.employee_id "Emp#", e2.last_name "Manager", e2.employee_id "Mgr#"
FROM employees e, employees e2 WHERE(e.manager_id = e2.employee_id(+)) ORDER BY e.employee_id;

SELECT e.last_name "����̸�", e.department_id "�μ�", e2.last_name "���� �μ� ���"
FROM employees e JOIN employees e2 ON(e.department_id = e2.department_id);

DESC jobs;
SELECT e.first_name, job_id, j.job_title, e.department_id, e.salary 
FROM employees e LEFT JOIN jobs j USING (job_id); 
--��������
SELECT first_name, hire_date FROM employees 
WHERE department_id = (SELECT department_id FROM employees WHERE UPPER(last_name) = 'ZLOTKEY'); 


