--1��
SELECT employee_id, first_name, job_id, hire_date FROM employees;
--2��
SELECT DISTINCT manager_id FROM employees WHERE manager_id IS NOT NULL;
--3��
SELECT employee_id, first_name, salary, department_id FROM employees WHERE  salary BETWEEN 7000 AND 12000 AND first_name Like 'H%';
--4��
SELECT employee_id, first_name, hire_date, SUBSTR(email,1,3) "EMAIL", LENGTH(email) "EMAIL LENGH" FROM employees WHERE hire_date >= TO_DATE('2005/01/01');
--5��
SELECT first_name, hire_date, ADD_MONTHS(hire_date, 6) "�Ի� 6���� ���� ��¥", NEXT_DAY(hire_date,'��') "�Ի� �� ù �ݿ���", 
TRUNC( MONTHS_BETWEEN(sysdate, hire_date) ) "�� �ٹ� ����", LAST_DAY(hire_date)+1 "ù �޿���" FROM employees ORDER BY hire_date;
--6��
SELECT employee_id, first_name, TO_CHAR(hire_date, 'DD/MM/YYYY DAY') "�Ի���", TO_CHAR( salary*NVL(commission_pct,0), '$999,999,999.99' ) "����" FROM employees ORDER BY "����" DESC;
--7��
SELECT employee_id, first_name, job_id, salary, department_id FROM employees WHERE department_id IN (50, 60) AND salary >5000;
--8��
SELECT employee_id, job_id, phone_number, department_id FROM employees WHERE phone_number LIKE '515%';
--9��
SELECT employee_id, first_name, ( salary + salary*NVL(commission_pct,0) )*12 "����" ,SUBSTR(hire_date,1,2) "�Ի�⵵",NVL2(commission_pct,'COMM','NOCOMM') "���", department_id  FROM employees 
ORDER BY department_id, "����";
--10��
SELECT employee_id, first_name, department_id,
    CASE department_id WHEN 20 THEN 'Canada'
                       WHEN 80 THEN 'UK'
                       ELSE 'USA'
    END
AS "�ٹ�����"
FROM employees;