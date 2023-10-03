<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서별 대여매출현황</title>
<style>
	table{
		border-collapse: collapse;
		margin: 50px auto;
		width: 70%;
		text-align: center;
	}
	
	.book_table {
		border: 1px solid black;
	}
	
	.book_table td, 
	.book_table th {
		border: 1px solid black;
	}
</style>
</head>
<body>
<h3>도서별 대여매출현황</h3>
<table class="book_table">
	<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>대여총계</th>
			<th>대여횟수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${rentList}" var="rent">
			<tr>
				<td>${rent.bookNo }</td>
				<td style="text-align: left;">${rent.bookName }</td>
				<td style="text-align: right;">${rent.sum }</td>
				<td style="text-align: right;">${rent.count }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>