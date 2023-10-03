<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서목록조회</title>
<style>
	img {
	width: 30px;
	}
	
	table{
		border-collapse: collapse;
		margin: 50px auto;
		width: 95%;
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
<h3>도서 조회/수정</h3>
<table class="book_table">
	<thead>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>표지</th>
			<th>출판일자</th>
			<th>금액</th>
			<th>출판사</th>
			<th>도서소개</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.bookNo }</td>
				<td>${book.bookName }</td>
				<td> <img alt="책 표지 사진" src="${pageContext.request.contextPath}/resources/images/${book.bookCoverimg }"> </td>
				<td>
					<fmt:formatDate value="${book.bookDate }" pattern="yyyy/MM/dd"/>
				</td>
				<td>
					<fmt:formatNumber value="${book.bookPrice }" pattern="#,###"/>
				</td>
				<td>${book.bookPublisher }</td>
				<td>${book.bookInfo }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>