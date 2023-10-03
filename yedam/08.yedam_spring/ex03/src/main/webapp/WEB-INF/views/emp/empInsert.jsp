<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록</title>
<style type="text/css">
	body {
		text-align: center;
	}
</style>
</head>
<body>
	<form action="empInsert" method="post">
		<div>
			<label>first_name : <input type="text" name="firstName"></label>
		</div>
		<div>
			<label>last_name : <input type="text" name="lastName"></label>
		</div>
		<div>
			<label>email : <input type="email" name="email"></label>
		</div>
		<div>
			<label>job_id : <input type="text" name="jobId"></label>
		</div>
		<div>
			<label>salary : <input type="number" name="salary"></label>
		</div>
		<button type="submit" class="btn btn-secondary mt-3">등록</button>
		<button type="button" class="btn btn-secondary mt-3">목록</button>
	</form>
</body>
</html>