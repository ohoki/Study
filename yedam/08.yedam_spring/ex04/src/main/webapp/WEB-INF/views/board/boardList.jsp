<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list</title>
<style>
	table, td, th {
		border-collapse: collapse;
		border: 1px solid black;
	}
	
	table {
		margin: 40px auto;
		width: 60%;
		text-align: center;
	}
</style>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="board">
				<tr onclick="location.href='boardInfo?bno=${board.bno}'">
					<td>${board.bno }</td>
					<td>${board.title }</td>
					<td>${board.writer }</td>
					<td>
						<fmt:formatDate value="${board.regidate}" pattern="yyyy년MM월dd일" /> 
					</td>
				</tr>
			</c:forEach>		
		</tbody>
	</table>
</body>
</html>