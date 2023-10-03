<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서 전체조회</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style type="text/css">
	body {
		text-align: center;
	}
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		padding: 5px 15px;
		text-align: center;
		margin: 0 auto;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='deptInsert'" class="btn btn-secondary mb-3">등록</button>
	<table>
		<thead>
			<tr>
				<th>department_id</th>
				<th>department_name</th>
				<th>manager_id</th>
				<th>location_id</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${deptList }" var="dept">
				<tr onclick="location.href='deptInfo?departmentId=${dept.departmentId}'">
					<td>${dept.departmentId}</td>
					<td>${dept.departmentName}</td>
					<c:if test="${dept.managerId == null}">
						<td>-</td>
					</c:if>
					<c:if test="${dept.managerId != null}">
						<td>${dept.managerId}</td>
					</c:if>
					<td>${dept.locationId}</td>
					<td><button type="button" class="btn btn-light">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<script>
		let msg = `${message}`;
		
		if (msg != null && msg != '') {
			alert(msg);
		}
		
		$('tbody > tr button[type="button"]').on('click', ajaxDeptDelete);
		
		function ajaxDeptDelete(e) {
			let deptId = $(e.currentTarget).parent().siblings().eq(0).text();
			console.log(deptId);
			
			$.ajax({
				url : 'deptDelete',
				type : 'post',
				data : {id : deptId}
			})
			.done(data => {
				if(data == 'Success') {
					alert('해당 정보가 삭제되었습니다.');
					$(e.currentTarget).parent().parent().remove();
				}else {
					alert('해당 정보는 삭제되지 않았습니다.');
				}
			})
			.fail(reject => console.log(reject));
			
			return false;
		}
	</script>
</body>
</html>