<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
<style>
	table{
		border-collapse: collapse;
		margin: 50px;
		width: 70%;
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
<h3>도서 등록</h3>
<form action="bookInsert" method="post" name="insertForm">
	<table class="book_table">
		<tbody>
			<tr>
				<th>
					<label>도서번호</label> 
				</th>
				<td>
					<input type="text" name="bookNo" readonly="readonly" value="${bookNo }">
				</td>
			</tr>
			<tr>
				<th>
					<label>도서명</label> 
				</th>
				<td>
					<input type="text" name="bookName">
				</td>
			</tr>
			<tr>
				<th>
					<label>도서표지</label> 
				</th>
				<td>
					<input type="text" name="bookCoverimg" >
				</td>
			</tr>
			<tr>
				<th>
					<label>출판일자</label> 
				</th>
				<td>
					<input type="text" name="bookDate" >
				</td>
			</tr>
			<tr>
				<th>
					<label>금액</label> 
				</th>
				<td>
					<input type="text" name="bookPrice" >
				</td>
			</tr>
			<tr>
				<th>
					<label>출판사</label> 
				</th>
				<td>
					<input type="text" name="bookPublisher" >
				</td>
			</tr>
			<tr>
				<th>
					<label>도서소개</label> 
				</th>
				<td>
					<textarea rows="4" cols="100" name="bookInfo"></textarea>
				</td>
			</tr>
		</tbody>
	</table>
	<button type="submit">등록</button>
	<button type="button" onclick="location.href='bookList'">조회</button>
</form>
<script>
	document.querySelector('form[name="insertForm"]')
			.addEventListener('submit', function(e) {
				e.preventDefault();
				
				let bookName = document.getElementsByName('bookName')[0];
				
				if(bookName.value == ''){
					alert('도서명이 입력되지 않았습니다.');
					bookName.focus();
					return;
				}
				
				alert('도서등록이 완료 되었습니다.');
				
				insertForm.submit();
			});
</script>
</body>
</html>