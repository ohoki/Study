<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp</title>
</head>
<body>
	<h3>사원조회</h3>
	<div>사원번호 : ${emp.employee_id }</div>
	<div>이름 : ${emp.first_name }</div>
	<div>입사일자 : ${emp.hire_date }</div>
	<div>급여 : ${emp.salary }</div>
</body>
</html>