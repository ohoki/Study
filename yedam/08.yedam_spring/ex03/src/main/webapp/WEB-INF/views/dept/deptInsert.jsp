<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 등록</title>
<style type="text/css">
	body {
		text-align: center;
	}
</style>
</head>
<body>
	<form action="deptInsert" method="post">
		<div>
			<label>부서이름 : <input type="text" name="departmentName" required="required"></label>
		</div>
		<div>
			<label>팀장번호 : <input type="text" name="managerId"></label>
		</div>
		<div>
			<label>위치번호 : <input type="text" name="locationId"></label>
		</div>
		<button type="submit" class="btn btn-secondary mt-3">등록</button>
		<button type="button" onclick="location.href='deptList'" class="btn btn-secondary mt-3">목록</button>
	</form>
</body>
</html>