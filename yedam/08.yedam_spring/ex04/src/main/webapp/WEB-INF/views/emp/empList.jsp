<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
</head>
<body>
	<script>
		// 태그를 제어하는 경우 태그가 생성되고 나서 함수가 작동해야 함
		document.addEventListener('DOMContentLoaded', function(e) {
			document.getElementById('cntPerPage')
				    .addEventListener('change', changeHandler);
		});
		
		function changeHandler(e) {
			let selected = e.currentTarget.value;
			location.href = 'empList?nowPage=${paging.nowPage}&cntPerPage=' + selected;
		}
	</script>
	<div>
		<div>
		<!-- 내부에 있는 c태그가 먼저 작동되고 html이 생성되기 때문에 이 코드가 작동되는 것 -->
			<select id="cntPerPage">
				<option value="5" <c:if test="${paging.cntPerPage == 5 }">selected</c:if>>5줄 보기</option>
				<option value="10" <c:if test="${paging.cntPerPage == 10 }">selected</c:if>>10줄 보기</option>
				<option value="15" <c:if test="${paging.cntPerPage == 15 }">selected</c:if>>15줄 보기</option>
				<option value="20" <c:if test="${paging.cntPerPage == 20 }">selected</c:if>>20줄 보기</option>
			</select>
		</div>
		<table border="1" style="width: 80%; margin: auto; text-align: center;">
			<thead>
				<tr>
					<th style="width: 20%">employee_id</th>
					<th style="width: 20%">first_name</th>
					<th style="width: 20%">last_name</th>
					<th style="width: 20%">email</th>
					<th style="width: 20%">job_id</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empList }" var="empInfo">
					<tr>
						<td>${empInfo.employeeId }</td>
						<td>${empInfo.firstName }</td>
						<td>${empInfo.lastName }</td>
						<td>${empInfo.email }</td>
						<td>${empInfo.jobId}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align: center;">
			<!-- 이전 -->
			<c:if test="${paging.startPage  != 1}">
				<a href="empList?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage }">&lt;</a>
			</c:if>
			<!-- View 안에 보여지는 페이지들 -->
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
				<c:choose>
					<c:when test="${p eq paging.nowPage}">
						<b>${p }</b>
					</c:when>
					<c:otherwise>
						<a href="empList?nowPage=${p }&cntPerPage=${paging.cntPerPage }">${p }</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- 다음 -->
			<c:if test="${paging.endPage  != paging.lastPage}">
				<a href="empList?nowPage=${paging.endPage + 1 }&cntPerPage=${paging.cntPerPage }">&gt;</a>
			</c:if>
		</div>
	</div>
</body>
</html>