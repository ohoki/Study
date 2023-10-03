<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
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
	<button type="button" onclick="location.href='empInsert'" class="btn btn-secondary mb-3">등록</button>
	<table>
		<thead>
			<tr>
				<th>employee_id</th>
				<th>first_name</th>
				<th>last_name</th>
				<th>email</th>
				<th>hire_date</th>
				<th>job_id</th>
				<th>salary</th>
				<th>delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp"> 
				<tr onclick="location.href='empInfo?employeeId=${emp.employeeId}'">
					<td>${emp.employeeId}</td>
					<td>${emp.firstName}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td>
						<fmt:formatDate value="${emp.hireDate }" pattern="yyyy년MM월dd일"/>
					</td>
					<td>${emp.jobId}</td>
					<td><fmt:formatNumber value="${emp.salary}" pattern="$#,###"></fmt:formatNumber></td>
					<td><button type="button" class="btn btn-light">삭제</button></td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
	<script type="text/javascript">
		printMessage(`${result}`);
	
		function printMessage(msg) {
			if(msg == null || msg == ''){
				return;	
			}
			alert(msg);
		}
		
		$('button:contains("삭제")').on('click', ajaxDeleteEmp);
		
		function ajaxDeleteEmp(e) {
			let empId = e.currentTarget.closest('tr').firstElementChild.textContent;
			
			$.ajax({
				url : 'empDelete',
				type : 'post',
				data : {id : empId}
			})
			.done( data => {
				if(data != null && data == 'Success') {
					alert('해당 사원의 정보가 정상적으로 삭제되었습니다.');
					let btn = e.currentTarget;
					$(btn).closest('tr').remove();
				} else {
					alert('해당 사원의 정보가 정상적으로 삭제되지 않았습니다.');
				}
			})
			.fail( reject => console.log(reject));
			
			//e.stopPropagation();
			return false;
		}
	</script>
</body>
</html>